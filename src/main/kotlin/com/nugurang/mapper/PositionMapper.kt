package com.nugurang.mapper

import com.nugurang.dto.PositionDto
import com.nugurang.entity.PositionEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface PositionMapper : GenericMapper<PositionDto, PositionEntity>