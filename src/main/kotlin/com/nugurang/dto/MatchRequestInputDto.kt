package com.nugurang.dto;

import java.time.OffsetDateTime

data class MatchRequestInputDto(
    val createdAt: OffsetDateTime,
    // TODO: Refactor
    val days: Int?,
    val hours: Int?,
    val minutes: Int?,
    val minTeamSize: Int,
    val maxTeamSize: Int,
    val type: Long,
    val event: Long
)