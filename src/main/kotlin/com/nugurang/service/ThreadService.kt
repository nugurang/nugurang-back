package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.constant.VoteTypeName
import com.nugurang.dao.*
import com.nugurang.dto.ThreadInputDto
import com.nugurang.dto.VoteInputDto
import com.nugurang.entity.ArticleEntity
import com.nugurang.entity.ThreadEntity
import com.nugurang.entity.XrefUserTeamEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@Validated
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
    private val xrefUserTeamDao: XrefUserTeamDao,
) {
    @PreAuthorize("hasPermission(#board, 'com.nugurang.entity.BoardEntity', 'WRITE')")
    @DaoOp
    fun createThread(@Valid threadInputDto: ThreadInputDto, board: Long): ThreadEntity {
        val userEntity = userService.getCurrentUser()
        val threadEntity = threadDao.save(
            ThreadEntity(
                name = threadInputDto.name,
                board = boardService.getBoard(board),
                xrefUserTeam = threadInputDto.team?.let {
                    xrefUserTeamDao.findByUserIdAndTeamId(userEntity.id!!, it)
                        ?: throw NotFoundException(XrefUserTeamEntity::class.java)
                },
                event = threadInputDto.event?.let {
                    eventDao.getById(it)
                },
                user = userEntity,
            )
        )
        articleService.createArticle(threadInputDto.firstArticle, threadEntity.id!!)
        return threadEntity
    }

    fun getFirstArticle(threadId: Long): ArticleEntity {
        val articles = getArticles(threadId, 0, 1)
        articles.isEmpty() && throw NotFoundException(ArticleEntity::class.java)
        return articles[0]
    }

    fun getArticles(threadId: Long, page: Int, pageSize: Int): List<ArticleEntity> {
        return articleDao.findAllByThreadIdOrderByCreatedAtAsc(
            threadId,
            PageRequest.of(page, pageSize)
        )
        .content
    }

    @DaoOp
    fun getThread(id: Long): ThreadEntity {
        val threadEntity = threadDao.findByIdOrNull(id)
            ?: throw NotFoundException(ThreadEntity::class.java)
        val articleEntity = articleDao.findFirstByThreadIdOrderByCreatedAtAsc(threadEntity.id!!)
            ?: throw NotFoundException(ArticleEntity::class.java)

        return try {
            voteService.getVote(
                userService.getCurrentUser().id!!,
                articleEntity.id!!,
                VoteTypeName.VIEW.name
            )
            threadEntity
        } catch (nfe: NotFoundException) {
            voteService.createVote(
                VoteInputDto(
                    articleEntity.id!!,
                    voteTypeDao.findByName(VoteTypeName.VIEW.name)?.id
                        ?: throw NotFoundException(VoteTypeName::class.java)
                )
            )
            threadEntity
        }
    }

    fun getThreadsByBoards(@NotEmpty boards: List<Long>, page: Int, pageSize: Int): List<ThreadEntity> {
        return threadDao.findAllByBoardIdInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize)).content
    }

    fun getThreadsByBoardNames(@NotEmpty boards: List<String>, page: Int, pageSize: Int): List<ThreadEntity> {
        return threadDao.findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize)).content
    }

    fun getHotThreadsByBoardNames(@NotEmpty boards: List<String>, page: Int, pageSize: Int): List<ThreadEntity> {
        return threadDao.findAllByBoardNameInOrderByCreatedAtDesc(boards, PageRequest.of(page, pageSize)).content
    }

    @DaoOp
    fun updateThread(@Valid threadInputDto: ThreadInputDto, id: Long): ThreadEntity {
        val threadEntity = threadDao.findByIdOrNull(id) ?: throw NotFoundException(ThreadEntity::class.java)
	threadEntity.name = threadInputDto.name
	// currently ignore other fields in threadInputDto
	return threadDao.save(threadEntity)
    }

    fun deleteThread(id: Long) {
        threadDao.deleteById(id)
    }
}
