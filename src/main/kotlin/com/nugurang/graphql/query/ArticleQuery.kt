package com.nugurang.graphql.query

import com.nugurang.dto.ArticleDto
import com.nugurang.service.ArticleService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class ArticleQuery(private val articleService: ArticleService) : GraphQLQueryResolver {

    fun getArticle(id: Long): ArticleDto {
        return articleService.getArticle(id).toDto()
    }
}