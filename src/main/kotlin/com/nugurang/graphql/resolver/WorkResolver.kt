package com.nugurang.graphql.resolver

import com.nugurang.dao.TaskDao
import com.nugurang.dao.WorkDao
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.TaskDto
import com.nugurang.dto.WorkDto
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.TaskEntity
import com.nugurang.entity.WorkEntity
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class WorkResolver(private val taskDao: TaskDao, private val workDao: WorkDao) : GraphQLResolver<WorkDto?> {

    fun project(workDto: WorkDto): ProjectDto {
        return workDao.findById(workDto.id).map { workEntity: WorkEntity -> workEntity.project }
            .map { projectEntity: ProjectEntity -> projectEntity.toDto() }.get()
    }

    fun tasks(workDto: WorkDto): List<TaskDto> {
        return taskDao.findAllByWorkId(workDto.id).stream().map { entity: TaskEntity -> entity.toDto() }
            .collect(Collectors.toList())
    }
}