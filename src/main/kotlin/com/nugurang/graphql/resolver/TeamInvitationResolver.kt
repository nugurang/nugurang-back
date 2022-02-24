package com.nugurang.graphql.resolver

import com.nugurang.dao.TeamInvitationDao
import com.nugurang.dto.InvitationStatusDto
import com.nugurang.dto.TeamDto
import com.nugurang.dto.TeamInvitationDto
import com.nugurang.dto.UserDto
import com.nugurang.entity.TeamInvitationEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.InvitationStatusMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TeamInvitationResolver(
    private val teamInvitationDao: TeamInvitationDao,
    private val invitationStatusMapper: InvitationStatusMapper
) : GraphQLResolver<TeamInvitationDto> {

    fun team(teamInvitationDto: TeamInvitationDto): TeamDto {
        return teamInvitationDao.findByIdOrNull(teamInvitationDto.id)
        ?.team
        ?.toDto()
        ?: throw NotFoundException(TeamInvitationEntity::class.java)
    }

    fun status(teamInvitationDto: TeamInvitationDto): InvitationStatusDto {
        return teamInvitationDao.findByIdOrNull(teamInvitationDto.id)
        ?.status
        ?.let(invitationStatusMapper::toDto)
        ?: throw NotFoundException(TeamInvitationEntity::class.java)
    }

    fun fromUser(teamInvitationDto: TeamInvitationDto): UserDto {
        return teamInvitationDao.findByIdOrNull(teamInvitationDto.id)
        ?.fromUser
        ?.toDto()
        ?: throw NotFoundException(TeamInvitationEntity::class.java)
    }

    fun toUser(teamInvitationDto: TeamInvitationDto): UserDto {
        return teamInvitationDao.findByIdOrNull(teamInvitationDto.id)
        ?.toUser
        ?.toDto()
        ?: throw NotFoundException(TeamInvitationEntity::class.java)
    }
}