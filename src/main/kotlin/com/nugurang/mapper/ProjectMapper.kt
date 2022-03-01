package com.nugurang.mapper

import com.nugurang.dto.ProjectDto
import com.nugurang.entity.ProjectEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProjectMapper : GenericMapper<ProjectDto, ProjectEntity>