package com.nugurang.graphql.query

import com.nugurang.dao.*
import com.nugurang.dto.*
import com.nugurang.entity.MatchTypeEntity
import com.nugurang.entity.TeamInvitationEntity
import com.nugurang.entity.VoteTypeEntity
import com.nugurang.exception.NotFoundException
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
    private val voteTypeDao: VoteTypeDao
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
            .findAllByUserId(userService.getCurrentUser().id)
            .map { it.toDto() }
    }

    fun invitationStatus(): List<InvitationStatusDto> {
        return invitationStatusDao.findAll().map { it.toDto() }
    }

    fun matchTypes(): List<MatchTypeDto> {
        return matchTypeDao.findAll().map { it.toDto() }
    }

    fun notificationTypes(): List<NotificationTypeDto> {
        return notificationTypeDao.findAll().map { it.toDto() }
    }

    fun positions(): List<PositionDto> {
        return positionDao.findAll().map { it.toDto() }
    }

    fun progresses(): List<ProgressDto> {
        return progressDao.findAll().map { it.toDto() }
    }

    fun voteTypes(): List<VoteTypeDto> {
        return voteTypeDao.findAll().map { it.toDto() }
    }

    fun getMatchTypeByName(name: String): MatchTypeDto {
        return matchTypeDao.findByName(name)?.toDto()
        ?: throw NotFoundException(MatchTypeEntity::class.java)
    }

    fun getProjectInvitation(id: Long): ProjectInvitationDto? {
        return projectInvitationDao.findByIdOrNull(id)?.toDto()
    }

    fun getTeamInvitation(id: Long): TeamInvitationDto {
        return teamInvitationDao.findByIdOrNull(id)?.toDto()
        ?: throw NotFoundException(TeamInvitationEntity::class.java)

    }

    fun getVoteTypeByName(name: String): VoteTypeDto {
        return voteTypeDao.findByName(name)?.toDto()
        ?: throw NotFoundException(VoteTypeEntity::class.java)
    }
}