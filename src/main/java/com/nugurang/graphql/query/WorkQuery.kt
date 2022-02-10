package com.nugurang.graphql.query

import com.nugurang.dto.WorkDto
import com.nugurang.service.WorkService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class WorkQuery(private val workService: WorkService) : GraphQLQueryResolver {
    fun getWork(id: Long): WorkDto {
        return workService.getWork(id).toDto()
    }
}