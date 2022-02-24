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
        return articleMapper.toDto(articleService.createArticle(articleInputDto, thread, parent))
    }

    fun updateArticle(articleInputDto: ArticleInputDto, id: Long): ArticleDto {
        return articleMapper.toDto(articleService.updateArticle(articleInputDto, id))
    }

    fun deleteArticle(id: Long): Long {
        articleService.deleteArticle(id)
        return id
    }
}