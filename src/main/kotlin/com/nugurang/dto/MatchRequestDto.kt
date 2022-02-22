package com.nugurang.dto;

import java.time.OffsetDateTime

data class MatchRequestDto(
    val id: Long,
    val createdAt: OffsetDateTime,
    val expiresAt: OffsetDateTime,
    val minTeamSize: Int,
    val maxTeamSize: Int?
)