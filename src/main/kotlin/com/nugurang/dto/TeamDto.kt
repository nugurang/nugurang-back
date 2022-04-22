package com.nugurang.dto;

data class TeamDto(
    override val id: Long,
    val name: String
) : GroupDto