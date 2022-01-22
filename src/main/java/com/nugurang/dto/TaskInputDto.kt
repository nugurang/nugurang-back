package com.nugurang.dto;

data class TaskInputDto(
    val name: String,
    val difficulty: Int?,
    val order: Int?,
    val progress: Long?,
    val users: List<Long>,
    val positions: List<Long>
)