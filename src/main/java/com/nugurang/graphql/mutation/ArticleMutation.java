package com.nugurang.graphql.mutation;

import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.ArticleInputDto;
import com.nugurang.service.ArticleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ArticleMutation implements GraphQLMutationResolver {
    private final ArticleService articleService;

    public ArticleDto createArticle(ArticleInputDto articleInputDto, Long thread, Optional<Long> parent) {
        return articleService.createArticle(articleInputDto, thread, parent).toDto();
    }

    public ArticleDto updateArticle(ArticleInputDto articleInputDto, Long id) {
        return articleService.updateArticle(articleInputDto, id).toDto();
    }

    public Long deleteArticle(Long id) {
        articleService.deleteArticle(id);
        return id;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ArticleMutation(final ArticleService articleService) {
        this.articleService = articleService;
    }
    //</editor-fold>
}
