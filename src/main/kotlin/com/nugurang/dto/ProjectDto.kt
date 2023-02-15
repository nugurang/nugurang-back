package com.nugurang.dto;

data class ProjectDto(
    override val id: Long,
    val name: String,
    val finished: Boolean
) : GroupDto