package com.nugurang.service

import com.nugurang.constant.VoteTypeName
import com.nugurang.dao.*
import com.nugurang.dto.ThreadInputDto
import com.nugurang.dto.VoteInputDto
import com.nugurang.entity.ArticleEntity
import com.nugurang.entity.EventEntity
import com.nugurang.entity.ThreadEntity
import com.nugurang.entity.XrefUserTeamEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ThreadService(
    private val articleService: ArticleService,
    private val boardService: BoardService,
    private val userService: UserService,
    private val voteService: VoteService,
    private val articleDao: ArticleDao,
    private val eventDao: EventDao,
    private val threadDao: ThreadDao,
    private val voteTypeDao: VoteTypeDao,
    private val xrefUserTeamDao: XrefUserTeamDao
) {
    @PreAuthorize("hasPermission(#board, 'com.nugurang.entity.BoardEntity', 'WRITE')")
    @Transactional
    fun createThread(threadInputDto: ThreadInputDto, board: Long): ThreadEntity {
        val userEntity = userService.getCurrentUser()
        val threadEntity = threadDao.save(
            ThreadEntity
            .builder()
            .name(threadInputDto.name)
            .board(boardService.getBoard(board))
            .xrefUserTeam(
                threadInputDto.team?.let { teamId ->
                    xrefUserTeamDao.findByUserIdAndTeamId(userEntity.id, teamId)
                        ?: throw NotFoundException(XrefUserTeamEntity::class.java)
                }
            )
            .event(
                threadInputDto.event?.let { eventId ->
                    eventDao.getById(eventId)
                        ?: throw NotFoundException(EventEntity::class.java)
                }
            )
            .user(userEntity)
            .build()
        )
        articleService.createArticle(threadInputDto.firstArticle, threadEntity.id)
        return threadEntity
    }

    @Transactional
    fun getThread(id: Long): ThreadEntity {
        val threadEntity = threadDao.findByIdOrNull(id)
            ?: throw NotFoundException(ThreadEntity::class.java)
        val articleEntity = articleDao.findFirstByThreadIdOrderByCreatedAtAsc(threadEntity.id)
            ?: throw NotFoundException(ArticleEntity::class.java)

        return try {
            voteService.getVote(
                userService.getCurrentUser().id,
                articleEntity.id,
                VoteTypeName.VIEW.name
            )
            threadEntity
        } catch (nfe: NotFoundException) {
            voteService.createVote(
                VoteInputDto(
                    articleEntity.id,
                    voteTypeDao.findByName(VoteTypeName.VIEW.name)?.id
                        ?: throw NotFoundException(VoteTypeName::class.java)
                )
            )
            threadEntity
        }
    }

    fun getThreadsByBoards(boards: List<Long>, page: Int, pageSize: Int): List<ThreadEntity> {
        return threadDao.findAllByBoardIdInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize)).content
    }

    fun getThreadsByBoardNames(boards: List<String>, page: Int, pageSize: Int): List<ThreadEntity> {
        return threadDao.findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize)).content
    }

    fun getHotThreadsByBoardNames(boards: List<String>, page: Int, pageSize: Int): List<ThreadEntity> {
        return threadDao.findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize)).content
    }

    fun updateThread(threadInputDto: ThreadInputDto, id: Long): ThreadEntity? {
        return null
    }

    fun deleteThread(id: Long) {
        threadDao.deleteById(id)
    }
}
