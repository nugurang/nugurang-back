package com.nugurang.mapper

import com.nugurang.dto.UserDto
import com.nugurang.entity.UserEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper : GenericMapper<UserDto, UserEntity>