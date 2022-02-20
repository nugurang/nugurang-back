package com.nugurang.dto

import java.time.OffsetDateTime

data class ArticleDto(
    val id: Long,
    val title: String?,
    val content: String,
    val createdAt: OffsetDateTime,
    val modifiedAt: OffsetDateTime
)