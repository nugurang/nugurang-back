package com.nugurang.dto;

import java.time.OffsetDateTime

data class UserEvaluationDto(
    val id: Long,
    val createdAt: OffsetDateTime,
    val expiresAt: OffsetDateTime
)