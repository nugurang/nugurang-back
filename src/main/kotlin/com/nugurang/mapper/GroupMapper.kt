package com.nugurang.mapper

import com.nugurang.dto.GroupDto
import com.nugurang.entity.GroupEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface GroupMapper : ReadOnlyMapper<GroupDto, GroupEntity>