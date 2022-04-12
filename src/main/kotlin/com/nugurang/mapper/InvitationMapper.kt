package com.nugurang.mapper

import com.nugurang.dto.InvitationDto
import com.nugurang.entity.InvitationEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface InvitationMapper : GenericMapper<InvitationDto, InvitationEntity>