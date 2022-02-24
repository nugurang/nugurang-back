package com.nugurang.graphql.resolver

import com.nugurang.dao.ProjectDao
import com.nugurang.dao.UserDao
import com.nugurang.dao.WorkDao
import com.nugurang.dto.*
import com.nugurang.entity.EventEntity
import com.nugurang.entity.TeamEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.EventMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProjectResolver(
    private val projectDao: ProjectDao,
    private val userDao: UserDao,
    private val workDao: WorkDao,
    private val eventMapper: EventMapper
) : GraphQLResolver<ProjectDto> {

    fun team(projectDto: ProjectDto): TeamDto {
        return projectDao.findByIdOrNull(projectDto.id)?.team?.toDto()
        ?: throw NotFoundException(TeamEntity::class.java)
    }

    fun getUsers(projectDto: ProjectDto, page: Int, pageSize: Int): List<UserDto> {
        return userDao.findAllByProjectId(projectDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun event(projectDto: ProjectDto): EventDto {
        return projectDao.findByIdOrNull(projectDto.id)?.event?.let(eventMapper::toDto)
        ?: throw NotFoundException(EventEntity::class.java)
    }

    fun works(projectDto: ProjectDto): List<WorkDto> {
        return workDao.findAllByProjectId(projectDto.id).stream().map { it.toDto() }.collect(Collectors.toList())
    }
}