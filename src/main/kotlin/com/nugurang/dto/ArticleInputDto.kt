package com.nugurang.dto

data class ArticleInputDto(
    val content: String,
    val title: String?,
    val images: List<Long>
)