package com.nugurang.graphql.query

import com.nugurang.dto.TaskDto
import com.nugurang.service.TaskService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class TaskQuery(private val taskService: TaskService) : GraphQLQueryResolver {
    fun getTask(id: Long): TaskDto {
        return taskService.getTask(id).toDto()
    }
}