package com.nugurang.mapper

import com.nugurang.dto.NotificationDto
import com.nugurang.entity.NotificationEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface NotificationMapper : GenericMapper<NotificationDto, NotificationEntity>