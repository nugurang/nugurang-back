package com.nugurang.graphql.resolver

import com.nugurang.dao.ProjectDao
import com.nugurang.dao.UserDao
import com.nugurang.dao.WorkDao
import com.nugurang.dto.*
import com.nugurang.entity.EventEntity
import com.nugurang.entity.TeamEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.EventMapper
import com.nugurang.mapper.TeamMapper
import com.nugurang.mapper.UserMapper
import com.nugurang.mapper.WorkMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProjectResolver(
    private val projectDao: ProjectDao,
    private val userDao: UserDao,
    private val workDao: WorkDao,
    private val eventMapper: EventMapper,
    private val teamMapper: TeamMapper,
    private val userMapper: UserMapper,
    private val workMapper: WorkMapper
) : GraphQLResolver<ProjectDto> {

    fun team(projectDto: ProjectDto): TeamDto {
        return projectDao.findByIdOrNull(projectDto.id)
        ?.team
        ?.let(teamMapper::toDto)
        ?: throw NotFoundException(TeamEntity::class.java)
    }

    fun getUsers(projectDto: ProjectDto, page: Int, pageSize: Int): List<UserDto> {
        return userDao.findAllByProjectId(projectDto.id, PageRequest.of(page, pageSize))
            .asSequence()
            .map(userMapper::toDto)
            .toList()
    }

    fun event(projectDto: ProjectDto): EventDto {
        return projectDao.findByIdOrNull(projectDto.id)?.event?.let(eventMapper::toDto)
        ?: throw NotFoundException(EventEntity::class.java)
    }

    fun works(projectDto: ProjectDto): List<WorkDto> {
        return workDao.findAllByProjectId(projectDto.id).map(workMapper::toDto)
    }
}