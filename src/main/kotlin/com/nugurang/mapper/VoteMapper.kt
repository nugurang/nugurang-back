package com.nugurang.mapper

import com.nugurang.dto.VoteDto
import com.nugurang.entity.VoteEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface VoteMapper : GenericMapper<VoteDto, VoteEntity>