package com.nugurang.dto

import javax.validation.constraints.NotBlank

data class BoardInputDto(
    @field:NotBlank
    val name: String,
    val placeholder: Boolean? = null
)