package com.nugurang.mapper

import com.nugurang.dto.TeamDto
import com.nugurang.entity.TeamEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TeamMapper : GenericMapper<TeamDto, TeamEntity>