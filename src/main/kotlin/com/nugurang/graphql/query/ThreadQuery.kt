package com.nugurang.graphql.query

import com.nugurang.dto.ThreadDto
import com.nugurang.mapper.ThreadMapper
import com.nugurang.service.ThreadService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class ThreadQuery(
    private val threadService: ThreadService,
    private val threadMapper: ThreadMapper
) : GraphQLQueryResolver {
    fun getThread(id: Long): ThreadDto {
        return threadService.getThread(id).let(threadMapper::toDto)
    }

    fun getThreadsByBoards(boards: List<Long>, page: Int, pageSize: Int): List<ThreadDto> {
        return threadService.getThreadsByBoards(boards, page, pageSize).map(threadMapper::toDto)
    }

    fun getThreadsByBoardNames(boards: List<String>, page: Int, pageSize: Int): List<ThreadDto> {
        return threadService.getThreadsByBoardNames(boards, page, pageSize).map(threadMapper::toDto)
    }

    fun getHotThreadsByBoardNames(boards: List<String>, page: Int, pageSize: Int): List<ThreadDto> {
        return threadService.getHotThreadsByBoardNames(boards, page, pageSize).map(threadMapper::toDto)
    }
}