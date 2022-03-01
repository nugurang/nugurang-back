package com.nugurang.graphql.query

import com.nugurang.dto.TaskDto
import com.nugurang.mapper.TaskMapper
import com.nugurang.service.TaskService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class TaskQuery(
    private val taskService: TaskService,
    private val taskMapper: TaskMapper
) : GraphQLQueryResolver {
    fun getTask(id: Long): TaskDto {
        return taskService.getTask(id).let(taskMapper::toDto)
    }
}