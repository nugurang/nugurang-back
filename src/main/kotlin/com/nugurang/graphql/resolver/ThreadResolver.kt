package com.nugurang.graphql.resolver

import com.nugurang.dao.ArticleDao
import com.nugurang.dao.ThreadDao
import com.nugurang.dto.*
import com.nugurang.entity.BoardEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.ArticleMapper
import com.nugurang.mapper.BoardMapper
import com.nugurang.service.ThreadService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ThreadResolver(
    private val articleDao: ArticleDao,
    private val threadDao: ThreadDao,
    private val threadService: ThreadService,
    private val articleMapper: ArticleMapper,
    private val boardMapper: BoardMapper
) : GraphQLResolver<ThreadDto> {
    fun board(threadDto: ThreadDto): BoardDto {
        val board = threadDao.findByIdOrNull(threadDto.id)?.board ?: throw NotFoundException(BoardEntity::class.java)
        return boardMapper.toDto(board)
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
        return articleMapper.toDto(threadService.getFirstArticle(threadDto.id))
    }

    fun getArticles(threadDto: ThreadDto, page: Int, pageSize: Int): List<ArticleDto> {
        return threadService.getArticles(threadDto.id, page, pageSize).map(articleMapper::toDto)
    }

    fun commentCount(threadDto: ThreadDto): Long {
        return articleDao.countByThreadId(threadDto.id) - 1
    }
}