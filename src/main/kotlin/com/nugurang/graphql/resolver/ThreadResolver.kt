package com.nugurang.graphql.resolver

import com.nugurang.dao.ArticleDao
import com.nugurang.dao.ThreadDao
import com.nugurang.dto.*
import com.nugurang.entity.ArticleEntity
import com.nugurang.entity.BoardEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ThreadResolver(
    private val articleDao: ArticleDao,
    private val threadDao: ThreadDao,
) : GraphQLResolver<ThreadDto> {
    fun board(threadDto: ThreadDto): BoardDto {
        val board = threadDao.findByIdOrNull(threadDto.id)?.board ?: throw NotFoundException(BoardEntity::class.java)
        return board.toDto()
    }

    fun user(threadDto: ThreadDto): UserDto {
        val user = threadDao.findByIdOrNull(threadDto.id)?.user ?: throw NotFoundException(UserEntity::class.java)
        return user.toDto()
    }

    fun team(threadDto: ThreadDto): TeamDto? {
        return null
    }

    fun event(threadDto: ThreadDto): EventDto? {
        return threadDao.findByIdOrNull(threadDto.id)?.event?.toDto()
    }

    fun tags(threadDto: ThreadDto?): List<TagDto>? {
        return null
    }

    fun firstArticle(threadDto: ThreadDto): ArticleDto {
        val articles = articleDao
            .findAllByThreadIdOrderByCreatedAtAsc(threadDto.id, PageRequest.of(0, 1))
            .content
            .stream()
            .collect(Collectors.toList())
        articles.size == 0 && throw NotFoundException(ArticleEntity::class.java)
        return articles[0].toDto()
    }

    fun getArticles(threadDto: ThreadDto, page: Int, pageSize: Int): List<ArticleDto> {
        return articleDao.findAllByThreadIdOrderByCreatedAtAsc(
            threadDto.id,
            PageRequest.of(page, pageSize)
        )
        .content
        .map { it.toDto() }
    }

    fun commentCount(threadDto: ThreadDto): Long {
        return articleDao.countByThreadId(threadDto.id) - 1
    }
}