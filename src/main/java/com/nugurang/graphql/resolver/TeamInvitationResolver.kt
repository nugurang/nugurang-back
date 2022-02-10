package com.nugurang.graphql.resolver

import com.nugurang.dao.TeamInvitationDao
import com.nugurang.dto.InvitationStatusDto
import com.nugurang.dto.TeamDto
import com.nugurang.dto.TeamInvitationDto
import com.nugurang.dto.UserDto
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class TeamInvitationResolver(private val teamInvitationDao: TeamInvitationDao) : GraphQLResolver<TeamInvitationDto?> {
    fun team(teamInvitationDto: TeamInvitationDto): TeamDto {
        return teamInvitationDao.findById(teamInvitationDto.id).get().team.toDto()
    }

    fun status(teamInvitationDto: TeamInvitationDto): InvitationStatusDto {
        return teamInvitationDao.findById(teamInvitationDto.id).get().status.toDto()
    }

    fun fromUser(teamInvitationDto: TeamInvitationDto): UserDto {
        return teamInvitationDao.findById(teamInvitationDto.id).get().fromUser.toDto()
    }

    fun toUser(teamInvitationDto: TeamInvitationDto): UserDto {
        return teamInvitationDao.findById(teamInvitationDto.id).get().toUser.toDto()
    }
}