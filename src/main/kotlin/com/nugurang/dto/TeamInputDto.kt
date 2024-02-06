package com.nugurang.dto;

import javax.validation.constraints.NotBlank

data class TeamInputDto(
    @field:NotBlank
    val name: String,
    val placeholder: Boolean?
)