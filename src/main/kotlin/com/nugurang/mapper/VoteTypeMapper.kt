package com.nugurang.mapper

import com.nugurang.dto.VoteTypeDto
import com.nugurang.entity.VoteTypeEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface VoteTypeMapper : GenericMapper<VoteTypeDto, VoteTypeEntity>