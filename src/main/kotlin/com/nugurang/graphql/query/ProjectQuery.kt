package com.nugurang.graphql.query

import com.nugurang.dto.ProjectDto
import com.nugurang.mapper.ProjectMapper
import com.nugurang.service.ProjectService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class ProjectQuery(
    private val projectService: ProjectService,
    private val projectMapper: ProjectMapper
) : GraphQLQueryResolver {
    fun getProject(id: Long): ProjectDto {
        return projectService.getProject(id).let(projectMapper::toDto)
    }
}