package com.nugurang.dto;

import java.time.OffsetDateTime

data class ThreadDto(
    val id: Long,
    val name: String,
    val createdAt: OffsetDateTime,
    val modifiedAt: OffsetDateTime
)