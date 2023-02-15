package com.nugurang.dto;

data class InvitationInputDto(
    val group: Long,
    val users: List<Long>
)