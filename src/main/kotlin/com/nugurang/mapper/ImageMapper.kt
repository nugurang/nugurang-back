package com.nugurang.mapper

import com.nugurang.dto.ImageDto
import com.nugurang.entity.ImageEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ImageMapper : GenericMapper<ImageDto, ImageEntity>