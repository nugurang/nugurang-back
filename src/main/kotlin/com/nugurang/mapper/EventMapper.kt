package com.nugurang.mapper

import com.nugurang.dto.EventDto
import com.nugurang.entity.EventEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface EventMapper : GenericMapper<EventDto, EventEntity>