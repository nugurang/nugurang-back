package com.nugurang.mapper

import com.nugurang.dto.MatchTypeDto
import com.nugurang.entity.MatchTypeEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface MatchTypeMapper : GenericMapper<MatchTypeDto, MatchTypeEntity>