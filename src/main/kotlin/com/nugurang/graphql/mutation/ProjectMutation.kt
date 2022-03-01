package com.nugurang.graphql.mutation

import com.nugurang.dto.ProjectDto
import com.nugurang.dto.ProjectInputDto
import com.nugurang.mapper.ProjectMapper
import com.nugurang.service.ProjectService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ProjectMutation(
    private val projectService: ProjectService,
    private val projectMapper: ProjectMapper
) : GraphQLMutationResolver {
    fun createProject(projectInputDto: ProjectInputDto, team: Long): ProjectDto {
        return projectService
            .createProject(projectInputDto, team)
            .let(projectMapper::toDto)
    }

    fun updateProject(projectInputDto: ProjectInputDto, id: Long): ProjectDto {
        return projectService
            .updateProject(projectInputDto, id)
            .let(projectMapper::toDto)
    }

    fun deleteProject(id: Long): Long {
        projectService.deleteProject(id)
        return id
    }
}