package com.nugurang.mapper

import com.nugurang.dto.GroupDto
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.TeamDto
import com.nugurang.entity.GroupEntity
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.TeamEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.mapstruct.SubclassExhaustiveStrategy
import org.mapstruct.SubclassMapping

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION
)
interface GroupMapper {
    @SubclassMapping(source = ProjectEntity::class, target = ProjectDto::class)
    @SubclassMapping(source = TeamEntity::class, target = TeamDto::class)
    fun toDto(groupEntity: GroupEntity) : GroupDto
}