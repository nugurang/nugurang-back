package com.nugurang.graphql.mutation

import com.nugurang.dto.WorkDto
import com.nugurang.dto.WorkInputDto
import com.nugurang.service.WorkService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class WorkMutation(private val workService: WorkService) : GraphQLMutationResolver {
    fun createWork(workInputDto: WorkInputDto, projectId: Long): WorkDto {
        return workService.createWork(workInputDto, projectId).toDto()
    }

    fun updateWork(workInputDto: WorkInputDto, workId: Long): WorkDto {
        return workService.updateWork(workInputDto, workId).toDto()
    }

    fun deleteWork(workId: Long): Long {
        workService.deleteWork(workId)
        return workId
    }
}