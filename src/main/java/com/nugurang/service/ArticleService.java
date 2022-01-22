package com.nugurang.service;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.XrefArticleImageDao;
import com.nugurang.dto.ArticleInputDto;
import com.nugurang.entity.ArticleEntity;
import com.nugurang.entity.XrefArticleImageEntity;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {
    private final UserService userService;
    private final ArticleDao articleDao;
    private final ImageDao imageDao;
    private final ThreadDao threadDao;
    private final XrefArticleImageDao xrefArticleImageDao;

    @Transactional
    public ArticleEntity createArticle(ArticleInputDto articleInputDto, Long thread, Optional<Long> parent) {
        final var articleEntity = articleDao.save(ArticleEntity.builder().title(articleInputDto.getTitle()).content(articleInputDto.getContent()).user(userService.getCurrentUser().get()).thread(threadDao.findById(thread).get()).parent(parent.flatMap(parentId -> articleDao.findById(parentId)).orElse(null)).build());
        xrefArticleImageDao.saveAll(articleInputDto.getImages().stream().map(imageId -> XrefArticleImageEntity.builder().article(articleEntity).image(imageDao.findById(imageId).orElse(null)).build()).collect(Collectors.toList()));
        return articleEntity;
    }

    public Optional<ArticleEntity> getArticle(Long articleId) {
        return articleDao.findById(articleId);
    }

    public ArticleEntity updateArticle(ArticleInputDto articleInputDto, Long id) {
        return null;
    }

    public Long deleteArticle(Long articleId) {
        articleDao.deleteById(articleId);
        return articleId;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ArticleService(final UserService userService, final ArticleDao articleDao, final ImageDao imageDao, final ThreadDao threadDao, final XrefArticleImageDao xrefArticleImageDao) {
        this.userService = userService;
        this.articleDao = articleDao;
        this.imageDao = imageDao;
        this.threadDao = threadDao;
        this.xrefArticleImageDao = xrefArticleImageDao;
    }
    //</editor-fold>
}
