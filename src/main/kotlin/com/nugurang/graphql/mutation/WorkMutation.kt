package com.nugurang.graphql.mutation

import com.nugurang.dto.WorkDto
import com.nugurang.dto.WorkInputDto
import com.nugurang.mapper.WorkMapper
import com.nugurang.service.WorkService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class WorkMutation(
    private val workService: WorkService,
    private val workMapper: WorkMapper
) : GraphQLMutationResolver {

    fun createWork(workInputDto: WorkInputDto, projectId: Long): WorkDto {
        return workService.createWork(workInputDto, projectId).let(workMapper::toDto)
    }

    fun updateWork(workInputDto: WorkInputDto, workId: Long): WorkDto {
        return workService.updateWork(workInputDto, workId).let(workMapper::toDto)
    }

    fun deleteWork(workId: Long): Long {
        workService.deleteWork(workId)
        return workId
    }
}