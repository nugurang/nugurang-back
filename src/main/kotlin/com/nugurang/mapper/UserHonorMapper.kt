package com.nugurang.mapper

import com.nugurang.dto.UserHonorDto
import com.nugurang.entity.UserHonorEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserHonorMapper : GenericMapper<UserHonorDto, UserHonorEntity>