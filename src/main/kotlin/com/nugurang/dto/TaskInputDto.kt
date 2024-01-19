package com.nugurang.dto;

import javax.validation.constraints.NotBlank

data class TaskInputDto(
    @field:NotBlank
    val name: String,
    val difficulty: Int?,
    val order: Int?,
    val progress: Long?,
    val users: List<Long>,
    val positions: List<Long>
)