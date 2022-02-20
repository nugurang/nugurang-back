package com.nugurang.graphql.mutation

import com.nugurang.dto.ArticleDto
import com.nugurang.dto.ArticleInputDto
import com.nugurang.service.ArticleService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ArticleMutation(private val articleService: ArticleService) : GraphQLMutationResolver {
    fun createArticle(articleInputDto: ArticleInputDto, thread: Long, parent: Long?): ArticleDto {
        return articleService.createArticle(articleInputDto, thread, parent).toDto()
    }

    fun updateArticle(articleInputDto: ArticleInputDto, id: Long): ArticleDto {
        return articleService.updateArticle(articleInputDto, id).toDto()
    }

    fun deleteArticle(id: Long): Long {
        articleService.deleteArticle(id)
        return id
    }
}