package com.nugurang.mapper

import com.nugurang.dto.ArticleDto
import com.nugurang.entity.ArticleEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ArticleMapper : GenericMapper<ArticleDto, ArticleEntity>