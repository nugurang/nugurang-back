package com.nugurang.mapper

import com.nugurang.dto.WorkDto
import com.nugurang.entity.WorkEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface WorkMapper : GenericMapper<WorkDto, WorkEntity>