package com.nugurang.graphql.resolver

import com.nugurang.dao.NotificationDao
import com.nugurang.dao.NotificationDataDao
import com.nugurang.dto.NotificationDto
import com.nugurang.dto.NotificationTypeDto
import com.nugurang.dto.UserDto
import com.nugurang.entity.NotificationTypeEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class NotificationResolver(
    private val notificationDao: NotificationDao,
    private val notificationDataDao: NotificationDataDao
) : GraphQLResolver<NotificationDto> {

    fun user(notificationDto: NotificationDto): UserDto {
        return notificationDao.findByIdOrNull(notificationDto.id)?.user?.toDto()
        ?: throw NotFoundException(UserEntity::class.java)
    }

    fun data(notificationDto: NotificationDto): List<String> {
        return notificationDataDao.findAllByNotificationIdOrderByIdAsc(notificationDto.id).map { it.value }
    }

    fun type(notificationDto: NotificationDto): NotificationTypeDto {
        return notificationDao.findByIdOrNull(notificationDto.id)?.notificationType?.toDto()
        ?: throw NotFoundException(NotificationTypeEntity::class.java)
    }
}