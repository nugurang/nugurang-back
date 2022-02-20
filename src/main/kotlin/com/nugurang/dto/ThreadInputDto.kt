package com.nugurang.dto;

data class ThreadInputDto(
    val name: String,
    val firstArticle: ArticleInputDto,
    val board: Long,
    val event: Long?,
    val team: Long?
)