package com.nugurang.service

import com.nugurang.dao.ArticleDao
import com.nugurang.dao.VoteDao
import com.nugurang.dao.VoteTypeDao
import com.nugurang.dto.VoteInputDto
import com.nugurang.entity.ArticleEntity
import com.nugurang.entity.VoteEntity
import com.nugurang.entity.VoteTypeEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class VoteService(
    private val userService: UserService,
    private val articleDao: ArticleDao,
    private val voteDao: VoteDao,
    private val voteTypeDao: VoteTypeDao
) {

    fun getVoteTypes(): List<VoteTypeEntity> {
        return voteTypeDao.findAll()
    }

    fun getVote(userId: Long, articleId: Long, voteTypeName: String): VoteEntity {
        return voteDao.findByUserIdAndArticleIdAndVoteTypeName(
            userId,
            articleId,
            voteTypeName
        ) ?: throw NotFoundException(VoteEntity::class.java)
    }

    fun createVote(voteInputDto: VoteInputDto): VoteEntity {
        // TODO: Prevent users vote their own articles
        return voteDao.save(
            VoteEntity(
                user = userService.getCurrentUser(),
                article = articleDao.findByIdOrNull(voteInputDto.article) ?: throw NotFoundException(ArticleEntity::class.java),
                voteType = voteTypeDao.findByIdOrNull(voteInputDto.voteType) ?: throw NotFoundException(VoteTypeEntity::class.java)
            )
        )
    }

    fun updateVote(voteInputDto: VoteInputDto, voteId: Long): VoteEntity {
        val voteEntity = voteDao.findByIdOrNull(voteId) ?: throw NotFoundException(VoteEntity::class.java)
        voteEntity.user = userService.getCurrentUser()
        voteEntity.article = articleDao.findByIdOrNull(voteInputDto.article)
            ?: throw NotFoundException(ArticleEntity::class.java)
        voteEntity.voteType = voteTypeDao.findByIdOrNull(voteInputDto.voteType)
            ?: throw NotFoundException(VoteTypeEntity::class.java)
        return voteDao.save(voteEntity)
    }

    fun deleteVote(id: Long) {
        voteDao.deleteById(id)
    }
}