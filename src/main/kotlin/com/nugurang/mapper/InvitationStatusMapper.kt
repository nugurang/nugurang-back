package com.nugurang.mapper

import com.nugurang.dto.InvitationStatusDto
import com.nugurang.entity.InvitationStatusEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface InvitationStatusMapper : GenericMapper<InvitationStatusDto, InvitationStatusEntity>