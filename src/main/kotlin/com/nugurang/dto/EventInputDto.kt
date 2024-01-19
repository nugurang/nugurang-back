package com.nugurang.dto;

import java.time.OffsetDateTime
import javax.validation.constraints.NotBlank

data class EventInputDto(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val description: String,
    val recruitingStart: OffsetDateTime,
    val recruitingEnd: OffsetDateTime,
    val eventStart: OffsetDateTime,
    val eventEnd: OffsetDateTime,
    val images: List<Long>
)