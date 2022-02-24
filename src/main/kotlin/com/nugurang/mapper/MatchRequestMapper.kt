package com.nugurang.mapper

import com.nugurang.dto.MatchRequestDto
import com.nugurang.entity.MatchRequestEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface MatchRequestMapper : GenericMapper<MatchRequestDto, MatchRequestEntity>