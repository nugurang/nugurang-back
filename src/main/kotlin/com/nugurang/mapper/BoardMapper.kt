package com.nugurang.mapper

import com.nugurang.dto.BoardDto
import com.nugurang.entity.BoardEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface BoardMapper : GenericMapper<BoardDto, BoardEntity>