package com.nugurang.mapper

import com.nugurang.dto.ThreadDto
import com.nugurang.entity.ThreadEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ThreadMapper : GenericMapper<ThreadDto, ThreadEntity>