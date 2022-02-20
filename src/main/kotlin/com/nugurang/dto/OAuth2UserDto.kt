package com.nugurang.dto;

data class OAuth2UserDto(
    val id: String,
    val provider: String,
    val name: String,
    val email: String
)