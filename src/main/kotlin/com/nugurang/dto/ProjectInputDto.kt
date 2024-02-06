package com.nugurang.dto;

import javax.validation.constraints.NotBlank

data class ProjectInputDto(
    @field:NotBlank
    val name: String,
    val event: Long?
)