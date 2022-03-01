package com.nugurang.mapper

import com.nugurang.dto.ProgressDto
import com.nugurang.entity.ProgressEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProgressMapper : GenericMapper<ProgressDto, ProgressEntity>