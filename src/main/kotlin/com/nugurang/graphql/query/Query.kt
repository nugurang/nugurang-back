package com.nugurang.graphql.query

import com.nugurang.dao.*
import com.nugurang.dto.*
import com.nugurang.entity.MatchTypeEntity
import com.nugurang.entity.TeamInvitationEntity
import com.nugurang.entity.VoteTypeEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.*
import com.nugurang.service.OAuth2Service
import com.nugurang.service.UserService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class Query(
    private val oauth2Service: OAuth2Service,
    private val userService: UserService,
    private val invitationStatusDao: InvitationStatusDao,
    private val matchRequestDao: MatchRequestDao,
    private val matchTypeDao: MatchTypeDao,
    private val notificationTypeDao: NotificationTypeDao,
    private val positionDao: PositionDao,
    private val progressDao: ProgressDao,
    private val projectInvitationDao: ProjectInvitationDao,
    private val teamInvitationDao: TeamInvitationDao,
    private val voteTypeDao: VoteTypeDao,
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
        return matchRequestDao
            .findAllByUserId(userService.getCurrentUser().id!!)
            .map(matchRequestMapper::toDto)
    }

    fun invitationStatus(): List<InvitationStatusDto> {
        return invitationStatusDao.findAll().map(invitationStatusMapper::toDto)
    }

    fun matchTypes(): List<MatchTypeDto> {
        return matchTypeDao.findAll().map(matchTypeMapper::toDto)
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
        return voteTypeDao.findAll().map(voteTypeMapper::toDto)
    }

    fun getMatchTypeByName(name: String): MatchTypeDto {
        return matchTypeDao.findByName(name)?.let(matchTypeMapper::toDto)
        ?: throw NotFoundException(MatchTypeEntity::class.java)
    }

    fun getProjectInvitation(id: Long): ProjectInvitationDto? {
        return projectInvitationDao.findByIdOrNull(id)?.let(projectInvitationMapper::toDto)
    }

    fun getTeamInvitation(id: Long): TeamInvitationDto {
        return teamInvitationDao.findByIdOrNull(id)?.let(teamInvitationMapper::toDto)
        ?: throw NotFoundException(TeamInvitationEntity::class.java)

    }

    fun getVoteTypeByName(name: String): VoteTypeDto {
        return voteTypeDao.findByName(name)?.let(voteTypeMapper::toDto)
        ?: throw NotFoundException(VoteTypeEntity::class.java)
    }
}