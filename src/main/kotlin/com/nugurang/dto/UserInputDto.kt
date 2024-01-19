package com.nugurang.dto;

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class UserInputDto(
    @field:NotBlank
    val name: String,
    @field:Email
    val email: String,
    val biography: String?,
    val image: Long?
)