package com.nugurang.service

import com.nugurang.constant.NotificationTypeName
import com.nugurang.dao.NotificationDao
import com.nugurang.dao.NotificationDataDao
import com.nugurang.dao.NotificationTypeDao
import com.nugurang.entity.*
import com.nugurang.exception.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NotificationService(
    private val notificationDao: NotificationDao,
    private val notificationDataDao: NotificationDataDao,
    private val notificationTypeDao: NotificationTypeDao
) {
    @Transactional
    private fun createNotification(
        userEntity: UserEntity,
        type: NotificationTypeName,
        data: List<String>
    ): NotificationEntity {
        val notificationEntity = notificationDao.save(
            NotificationEntity(
                isRead = false,
                notificationType = notificationTypeDao.findByName(type.name)
                    ?: throw NotFoundException(NotificationTypeEntity::class.java),
                user = userEntity
            )
        )
        notificationDataDao.saveAll(
            data.map {
                NotificationDataEntity(
                    value = it,
                    notification = notificationEntity
                )
            }
        )
        return notificationEntity
    }

    fun createProjectInvitationNotification(
        userEntity: UserEntity,
        projectInvitationEntity: ProjectInvitationEntity
    ): NotificationEntity {

        return createNotification(
            userEntity,
            NotificationTypeName.PROJECT_INVITATION,
            listOf(projectInvitationEntity.id.toString())
        )
    }

    fun createTeamInvitationNotification(
        userEntity: UserEntity,
        teamInvitationEntity: TeamInvitationEntity
    ): NotificationEntity {
        return createNotification(
            userEntity,
            NotificationTypeName.TEAM_INVITATION,
            listOf(teamInvitationEntity.id.toString())
        )
    }

    fun createMatchSuccessNotification(
        userEntity: UserEntity,
        matchTypeEntity: MatchTypeEntity,
        eventEntity: EventEntity,
        teamEntity: TeamEntity
    ): NotificationEntity {
        log.info("Match " + eventEntity.id + " successfully created matchmaking.")
        return createNotification(
            userEntity,
            NotificationTypeName.MATCH_SUCCESS,
            listOf(matchTypeEntity.id.toString(), eventEntity.id.toString(), teamEntity.id.toString())
        )
    }

    fun createMatchFailureNotification(
        userEntity: UserEntity,
        matchTypeEntity: MatchTypeEntity,
        eventEntity: EventEntity
    ): NotificationEntity {
        log.info("Match " + eventEntity.id + " failed to create matchmaking.")
        return createNotification(
            userEntity,
            NotificationTypeName.MATCH_FAILURE,
            listOf(matchTypeEntity.id.toString(), eventEntity.id.toString())
        )
    }

    fun getNotification(notificationId: Long): NotificationEntity {
        return notificationDao.findByIdOrNull(notificationId)
            ?: throw NotFoundException(NotificationEntity::class.java)
    }

    companion object {
        private val log = LoggerFactory.getLogger(NotificationService::class.java)
    }
}