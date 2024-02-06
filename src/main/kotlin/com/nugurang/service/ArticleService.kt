package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.dao.ArticleDao
import com.nugurang.dao.ImageDao
import com.nugurang.dao.ThreadDao
import com.nugurang.dao.XrefArticleImageDao
import com.nugurang.dto.ArticleInputDto
import com.nugurang.entity.ArticleEntity
import com.nugurang.entity.ImageEntity
import com.nugurang.entity.ThreadEntity
import com.nugurang.entity.XrefArticleImageEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Validated
@Service
class ArticleService(
    private val userService: UserService,
    private val articleDao: ArticleDao,
    private val imageDao: ImageDao,
    private val threadDao: ThreadDao,
    private val xrefArticleImageDao: XrefArticleImageDao
) {
    @DaoOp
    fun createArticle(@Valid articleInputDto: ArticleInputDto, threadId: Long, parentId: Long? = null): ArticleEntity {
        val articleEntity = articleDao.save(
            ArticleEntity(
                title = articleInputDto.title,
                content = articleInputDto.content,
                user = userService.getCurrentUser(),
                thread = threadDao.findByIdOrNull(threadId) ?: throw NotFoundException(ThreadEntity::class.java),
                parent = parentId?.let { articleDao.findByIdOrNull(parentId) }
            )
        )
        xrefArticleImageDao.saveAll(
            articleInputDto.images.map { imageId: Long ->
                XrefArticleImageEntity(
                    article = articleEntity,
                    image = imageDao.findByIdOrNull(imageId) ?: throw NotFoundException(ImageEntity::class.java)
                )
            }
        )
        return articleEntity
    }

    fun getArticle(articleId: Long): ArticleEntity {
        return articleDao.findByIdOrNull(articleId) ?: throw NotFoundException(ArticleEntity::class.java);
    }

    @DaoOp
    fun updateArticle(@Valid articleInputDto: ArticleInputDto, articleId: Long): ArticleEntity {
        // TODO: Implement updating images
        val articleEntity = articleDao.getById(articleId)
        articleEntity.title = articleInputDto.title
        articleEntity.content = articleInputDto.content
        return articleDao.save(articleEntity)
    }

    @DaoOp
    fun deleteArticle(articleId: Long): Long {
        articleDao.deleteById(articleId)
        return articleId
    }
}