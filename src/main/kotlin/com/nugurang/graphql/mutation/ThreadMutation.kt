package com.nugurang.graphql.mutation

import com.nugurang.dto.ThreadDto
import com.nugurang.dto.ThreadInputDto
import com.nugurang.service.ThreadService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ThreadMutation(private val threadService: ThreadService) : GraphQLMutationResolver {
    fun createThread(threadInputDto: ThreadInputDto, board: Long): ThreadDto {
        return threadService.createThread(threadInputDto, board).toDto()
    }

    fun updateThread(threadInputDto: ThreadInputDto, id: Long): ThreadDto {
        return threadService.updateThread(threadInputDto, id).toDto()
    }

    fun deleteThread(id: Long): Long {
        threadService.deleteThread(id)
        return id
    }
}