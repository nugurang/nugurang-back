package com.nugurang.graphql.mutation

import com.nugurang.dto.ArticleDto
import com.nugurang.dto.ArticleInputDto
import com.nugurang.mapper.ArticleMapper
import com.nugurang.service.ArticleService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ArticleMutation(
    private val articleService: ArticleService,
    private val articleMapper: ArticleMapper
) : GraphQLMutationResolver {
    fun createArticle(articleInputDto: ArticleInputDto, thread: Long, parent: Long?): ArticleDto {
        return articleService.createArticle(articleInputDto, thread, parent).let(articleMapper::toDto)
    }

    fun updateArticle(articleInputDto: ArticleInputDto, id: Long): ArticleDto {
        return articleService.updateArticle(articleInputDto, id).let(articleMapper::toDto)
    }

    fun deleteArticle(id: Long): Long {
        articleService.deleteArticle(id)
        return id
    }
}