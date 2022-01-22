package com.nugurang.dto;

data class ProjectInvitationInputDto(
    val project: Long,
    val users: List<Long>
)