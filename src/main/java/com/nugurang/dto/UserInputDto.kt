package com.nugurang.dto;

data class UserInputDto(
    val name: String,
    val email: String,
    val biography: String?,
    val image: Long?
)