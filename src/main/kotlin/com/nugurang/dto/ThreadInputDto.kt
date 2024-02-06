package com.nugurang.dto;

import javax.validation.constraints.NotBlank

data class ThreadInputDto(
    @field:NotBlank
    val name: String,
    val firstArticle: ArticleInputDto,
    val board: Long,
    val event: Long?,
    val team: Long?
)