package com.nugurang.graphql.resolver

import com.nugurang.dao.TaskDao
import com.nugurang.dao.WorkDao
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.TaskDto
import com.nugurang.dto.WorkDto
import com.nugurang.entity.ProjectEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.ProjectMapper
import com.nugurang.mapper.TaskMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class WorkResolver(
    private val taskDao: TaskDao,
    private val workDao: WorkDao,
    private val projectMapper: ProjectMapper,
    private val taskMapper: TaskMapper
) : GraphQLResolver<WorkDto> {

    fun project(workDto: WorkDto): ProjectDto {
        return workDao
            .findByIdOrNull(workDto.id)
            ?.let { it.project }
            ?.let(projectMapper::toDto)
            ?: throw NotFoundException(ProjectEntity::class.java)
    }

    fun tasks(workDto: WorkDto): List<TaskDto> {
        return taskDao
            .findAllByWorkId(workDto.id)
            .map(taskMapper::toDto)
    }
}