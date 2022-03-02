package com.nugurang.graphql.query

import com.nugurang.dto.NotificationDto
import com.nugurang.mapper.NotificationMapper
import com.nugurang.service.NotificationService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class NotificationQuery(
    private val notificationService: NotificationService,
    private val notificationMapper: NotificationMapper
) : GraphQLQueryResolver {
    fun getNotification(id: Long): NotificationDto {
        return notificationService.getNotification(id).let(notificationMapper::toDto)
    }
}