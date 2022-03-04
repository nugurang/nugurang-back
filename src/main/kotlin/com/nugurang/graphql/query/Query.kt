package com.nugurang.graphql.query

import com.nugurang.dao.*
import com.nugurang.dto.*
import com.nugurang.entity.ProjectInvitationEntity
import com.nugurang.entity.TeamInvitationEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.*
import com.nugurang.service.MatchService
import com.nugurang.service.OAuth2Service
import com.nugurang.service.VoteService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class Query(
    private val matchService: MatchService,
    private val oauth2Service: OAuth2Service,
    private val voteService: VoteService,
    private val invitationStatusDao: InvitationStatusDao,
    private val notificationTypeDao: NotificationTypeDao,
    private val positionDao: PositionDao,
    private val progressDao: ProgressDao,
    private val projectInvitationDao: ProjectInvitationDao,
    private val teamInvitationDao: TeamInvitationDao,
    private val invitationStatusMapper: InvitationStatusMapper,
    private val matchRequestMapper: MatchRequestMapper,
    private val matchTypeMapper: MatchTypeMapper,
    private val notificationTypeMapper: NotificationTypeMapper,
    private val positionMapper: PositionMapper,
    private val progressMapper: ProgressMapper,
    private val projectInvitationMapper: ProjectInvitationMapper,
    private val teamInvitationMapper: TeamInvitationMapper,
    private val voteTypeMapper: VoteTypeMapper
) : GraphQLQueryResolver {

    fun ping(): String {
        return "pong"
    }

    fun currentOAuth2User(): OAuth2UserDto {
        return OAuth2UserDto(
            oauth2Service.getProvider(),
            oauth2Service.getId(),
            oauth2Service.getName(),
            oauth2Service.getEmail()
        )
    }

    fun matchRequests(): List<MatchRequestDto> {
        return matchService.getMatchRequests().map(matchRequestMapper::toDto)
    }

    fun invitationStatus(): List<InvitationStatusDto> {
        return invitationStatusDao.findAll().map(invitationStatusMapper::toDto)
    }

    fun matchTypes(): List<MatchTypeDto> {
        return matchService.getMatchTypes().map(matchTypeMapper::toDto)
    }

    fun notificationTypes(): List<NotificationTypeDto> {
        return notificationTypeDao.findAll().map(notificationTypeMapper::toDto)
    }

    fun positions(): List<PositionDto> {
        return positionDao.findAll().map(positionMapper::toDto)
    }

    fun progresses(): List<ProgressDto> {
        return progressDao.findAll().map(progressMapper::toDto)
    }

    fun voteTypes(): List<VoteTypeDto> {
        return voteService.getVoteTypes().map(voteTypeMapper::toDto)
    }

    fun getProjectInvitation(id: Long): ProjectInvitationDto {
        return projectInvitationDao.findByIdOrNull(id)?.let(projectInvitationMapper::toDto)
        ?: throw NotFoundException(ProjectInvitationEntity::class.java)
    }

    fun getTeamInvitation(id: Long): TeamInvitationDto {
        return teamInvitationDao.findByIdOrNull(id)?.let(teamInvitationMapper::toDto)
        ?: throw NotFoundException(TeamInvitationEntity::class.java)
    }
}