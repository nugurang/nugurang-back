package com.nugurang.graphql.mutation

import com.nugurang.dto.ThreadDto
import com.nugurang.dto.ThreadInputDto
import com.nugurang.mapper.ThreadMapper
import com.nugurang.service.ThreadService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ThreadMutation(
    private val threadService: ThreadService,
    private val threadMapper: ThreadMapper
) : GraphQLMutationResolver {
    fun createThread(threadInputDto: ThreadInputDto, board: Long): ThreadDto {
        return threadService
            .createThread(threadInputDto, board)
            .let(threadMapper::toDto)
    }

    fun updateThread(threadInputDto: ThreadInputDto, id: Long): ThreadDto {
        return threadService
            .updateThread(threadInputDto, id)
            .let(threadMapper::toDto)
    }

    fun deleteThread(id: Long): Long {
        threadService.deleteThread(id)
        return id
    }
}