package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.constant.NotificationTypeName
import com.nugurang.dao.NotificationDao
import com.nugurang.dao.NotificationDataDao
import com.nugurang.dao.NotificationTypeDao
import com.nugurang.entity.*
import com.nugurang.exception.NotFoundException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val notificationDao: NotificationDao,
    private val notificationDataDao: NotificationDataDao,
    private val notificationTypeDao: NotificationTypeDao
) {
    private val logger = KotlinLogging.logger {}
    @DaoOp
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

    @DaoOp
    fun createInvitationNotification(
        userEntity: UserEntity,
        invitationEntity: InvitationEntity
    ): NotificationEntity {

        return createNotification(
            userEntity,
            NotificationTypeName.INVITATION,
            listOf(invitationEntity.id.toString())
        )
    }

    @DaoOp
    fun createMatchSuccessNotification(
        userEntity: UserEntity,
        matchTypeEntity: MatchTypeEntity,
        eventEntity: EventEntity,
        teamEntity: TeamEntity
    ): NotificationEntity {
        logger.info { "Match ${eventEntity.id} successfully created matchmaking." }
        return createNotification(
            userEntity,
            NotificationTypeName.MATCH_SUCCESS,
            listOf(matchTypeEntity.id.toString(), eventEntity.id.toString(), teamEntity.id.toString())
        )
    }

    @DaoOp
    fun createMatchFailureNotification(
        userEntity: UserEntity,
        matchTypeEntity: MatchTypeEntity,
        eventEntity: EventEntity
    ): NotificationEntity {
        logger.info { "Match ${eventEntity.id} failed to create matchmaking." }
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
}
