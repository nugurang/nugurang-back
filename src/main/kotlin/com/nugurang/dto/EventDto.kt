package com.nugurang.dto;

import java.time.OffsetDateTime

data class EventDto(
    val id: Long,
    val name: String,
    val description: String,
    val recruitingStart: OffsetDateTime,
    val recruitingEnd: OffsetDateTime,
    val eventStart: OffsetDateTime,
    val eventEnd: OffsetDateTime
)