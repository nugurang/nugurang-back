package com.nugurang.mapper

import com.nugurang.dto.TaskDto
import com.nugurang.entity.TaskEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TaskMapper : GenericMapper<TaskDto, TaskEntity>