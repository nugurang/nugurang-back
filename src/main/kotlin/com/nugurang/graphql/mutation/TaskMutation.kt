package com.nugurang.graphql.mutation

import com.nugurang.dto.TaskDto
import com.nugurang.dto.TaskInputDto
import com.nugurang.mapper.TaskMapper
import com.nugurang.service.TaskService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class TaskMutation(
    private val taskService: TaskService,
    private val taskMapper: TaskMapper
) : GraphQLMutationResolver {

    fun createTask(taskInputDto: TaskInputDto, workId: Long): TaskDto {
        return taskService
            .createTask(taskInputDto, workId)
            .let(taskMapper::toDto)
    }

    fun updateTask(taskInputDto: TaskInputDto, taskId: Long): TaskDto {
        return taskService
            .updateTask(taskInputDto, taskId)
            .let(taskMapper::toDto)
    }

    fun deleteTask(taskId: Long): Long {
        taskService.deleteTask(taskId)
        return taskId
    }
}