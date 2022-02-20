package com.nugurang.dto;

data class TaskDto(
    val id: Long,
    val name: String,
    val order: Int,
    val difficulty: Int
)