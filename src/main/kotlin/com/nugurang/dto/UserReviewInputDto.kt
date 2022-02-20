package com.nugurang.dto;
data class UserReviewInputDto(
    val toUser: Long,
    val honors: List<PositionHonorInputDto>
)