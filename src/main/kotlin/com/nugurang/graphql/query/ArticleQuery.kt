package com.nugurang.graphql.query

import com.nugurang.dto.ArticleDto
import com.nugurang.mapper.ArticleMapper
import com.nugurang.service.ArticleService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class ArticleQuery(
    private val articleService: ArticleService,
    private val articleMapper: ArticleMapper
) : GraphQLQueryResolver {
    fun getArticle(id: Long): ArticleDto {
        return articleMapper.toDto(articleService.getArticle(id))
    }
}