package com.nugurang.graphql.query

import com.nugurang.dto.NotificationDto
import com.nugurang.service.NotificationService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class NotificationQuery(private val notificationService: NotificationService) : GraphQLQueryResolver {
    fun getNotification(id: Long): NotificationDto {
        return notificationService.getNotification(id).toDto()
    }
}