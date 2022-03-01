package com.nugurang.graphql.resolver

import com.nugurang.dao.ProjectInvitationDao
import com.nugurang.dto.InvitationStatusDto
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.ProjectInvitationDto
import com.nugurang.dto.UserDto
import com.nugurang.entity.InvitationStatusEntity
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.InvitationStatusMapper
import com.nugurang.mapper.ProjectMapper
import com.nugurang.mapper.UserMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProjectInvitationResolver(
    private val projectInvitationDao: ProjectInvitationDao,
    private val invitationStatusMapper: InvitationStatusMapper,
    private val projectMapper: ProjectMapper,
    private val userMapper: UserMapper
) : GraphQLResolver<ProjectInvitationDto> {

    fun project(projectInvitationDto: ProjectInvitationDto): ProjectDto {
        return projectInvitationDao.findByIdOrNull(projectInvitationDto.id)
        ?.project
        ?.let(projectMapper::toDto)
        ?: throw NotFoundException(ProjectEntity::class.java)
    }

    fun status(projectInvitationDto: ProjectInvitationDto): InvitationStatusDto {
        return projectInvitationDao.findByIdOrNull(projectInvitationDto.id)
        ?.let { invitationStatusMapper.toDto(it.status) }
        ?: throw NotFoundException(InvitationStatusEntity::class.java)
    }

    fun fromUser(projectInvitationDto: ProjectInvitationDto): UserDto {
        return projectInvitationDao.findByIdOrNull(projectInvitationDto.id)
        ?.fromUser
        ?.let(userMapper::toDto)
        ?: throw NotFoundException(UserEntity::class.java)
    }

    fun toUser(projectInvitationDto: ProjectInvitationDto): UserDto {
        return projectInvitationDao.findByIdOrNull(projectInvitationDto.id)
        ?.toUser
        ?.let(userMapper::toDto)
        ?: throw NotFoundException(UserEntity::class.java)
    }
}