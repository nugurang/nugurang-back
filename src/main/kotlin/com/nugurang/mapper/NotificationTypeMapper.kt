package com.nugurang.mapper

import com.nugurang.dto.NotificationTypeDto
import com.nugurang.entity.NotificationTypeEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface NotificationTypeMapper : GenericMapper<NotificationTypeDto, NotificationTypeEntity>