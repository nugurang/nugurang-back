package com.nugurang.dto;

import javax.validation.constraints.NotBlank

data class WorkInputDto(
    @field:NotBlank
    val name: String,
    val order: Int?
)