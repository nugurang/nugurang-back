package com.nugurang.mapper

import com.nugurang.dto.TeamInvitationDto
import com.nugurang.entity.TeamInvitationEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TeamInvitationMapper : GenericMapper<TeamInvitationDto, TeamInvitationEntity>