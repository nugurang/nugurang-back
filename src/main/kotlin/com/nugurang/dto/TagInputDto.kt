package com.nugurang.dto;

import javax.validation.constraints.NotBlank

data class TagInputDto(
    @field:NotBlank
    val name: String,
    val placeholder: Boolean?
)