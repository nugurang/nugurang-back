package com.nugurang.dto;

data class TeamInvitationInputDto(
    val team: Long,
    val users: List<Long>
)