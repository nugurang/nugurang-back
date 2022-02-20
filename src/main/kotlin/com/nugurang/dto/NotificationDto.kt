package com.nugurang.dto;

import java.time.OffsetDateTime

data class NotificationDto(
    val id: Long,
    val isRead: Boolean,
    val createdAt: OffsetDateTime
)