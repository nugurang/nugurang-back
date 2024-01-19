package com.nugurang.dto;

import javax.validation.constraints.NotBlank

data class PositionInputDto(
    val id: Long,
    @field:NotBlank
    val name: String,
    val description: String?,
    val image: Long?
)