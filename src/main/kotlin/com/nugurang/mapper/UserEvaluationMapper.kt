package com.nugurang.mapper

import com.nugurang.dto.UserEvaluationDto
import com.nugurang.entity.UserEvaluationEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserEvaluationMapper : GenericMapper<UserEvaluationDto, UserEvaluationEntity>