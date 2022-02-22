package com.nugurang.dto;

data class UserDto(
    val id: Long,
    val oauth2Provider: String,
    val oauth2Id: String,
    val name: String,
    val email: String,
    val biography: String?
)