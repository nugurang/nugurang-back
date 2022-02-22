package com.nugurang.dao

import com.nugurang.entity.NotificationDataEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificationDataDao : JpaRepository<NotificationDataEntity, Long> {
    fun findAllByNotificationIdOrderByIdAsc(notification: Long): List<NotificationDataEntity>
}