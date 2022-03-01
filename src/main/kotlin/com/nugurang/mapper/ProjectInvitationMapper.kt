package com.nugurang.mapper

import com.nugurang.dto.ProjectInvitationDto
import com.nugurang.entity.ProjectInvitationEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProjectInvitationMapper : GenericMapper<ProjectInvitationDto, ProjectInvitationEntity>