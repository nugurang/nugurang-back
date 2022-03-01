package com.nugurang.mapper

import com.nugurang.dto.UserReviewDto
import com.nugurang.entity.UserReviewEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserReviewMapper : GenericMapper<UserReviewDto, UserReviewEntity>