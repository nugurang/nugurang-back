package com.nugurang.graphql.resolver

import com.nugurang.dao.ThreadDao
import com.nugurang.dao.UserDao
import com.nugurang.dto.BoardDto
import com.nugurang.dto.ThreadDto
import com.nugurang.dto.UserDto
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class BoardResolver(private val userDao: UserDao, private val threadDao: ThreadDao) : GraphQLResolver<BoardDto> {
    fun getUsers(boardDto: BoardDto, page: Int, pageSize: Int): List<UserDto> {
        return userDao.findAllByBoardId(boardDto.id, PageRequest.of(page, pageSize)).content.map { it.toDto() }
    }

    fun getThreads(boardDto: BoardDto, page: Int, pageSize: Int): List<ThreadDto> {
        return threadDao.findAllByBoardIdOrderByCreatedAtDesc(
            boardDto.id,
            PageRequest.of(page, pageSize)
        )
        .content
        .map { it.toDto() }
    }
}