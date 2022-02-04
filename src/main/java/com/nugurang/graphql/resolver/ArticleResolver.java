package com.nugurang.graphql.resolver;

import com.nugurang.dao.ArticleDao;
import com.nugurang.dao.ImageDao;
import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.VoteDao;
import com.nugurang.dao.VoteTypeDao;
import com.nugurang.dto.ArticleDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.TagDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ArticleResolver implements GraphQLResolver<ArticleDto> {
    private final ArticleDao articleDao;
    private final ImageDao imageDao;
    private final ThreadDao threadDao;
    private final UserDao userDao;
    private final VoteDao voteDao;
    private final VoteTypeDao voteTypeDao;

    public ThreadDto thread(ArticleDto articleDto) {
        return articleDao.findById(articleDto.getId()).map(articleEntity -> articleEntity.getThread()).map(entity -> entity.toDto()).get();
    }

    public UserDto user(ArticleDto articleDto) {
        return articleDao.findById(articleDto.getId()).map(articleEntity -> articleEntity.getUser()).map(userEntity -> userEntity.toDto()).get();
    }

    public Optional<ArticleDto> parent(ArticleDto articleDto) {
        return articleDao.findById(articleDto.getId()).map(articleEntity -> articleEntity.getParent()).map(entity -> entity.toDto());
    }

    public List<ImageDto> images(ArticleDto articleDto) {
        return imageDao.findAllByArticleId(articleDto.getId()).stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    public List<TagDto> tags(ArticleDto articleDto) {
        return null;
    }

    public Long viewCount(ArticleDto articleDto) {
        return voteDao.countByArticleIdAndVoteTypeId(articleDto.getId(), voteTypeDao.findByName("VIEW").getId());
    }

    public Long upCount(ArticleDto articleDto) {
        return voteDao.countByArticleIdAndVoteTypeId(articleDto.getId(), voteTypeDao.findByName("UP").getId());
    }

    public Long downCount(ArticleDto articleDto) {
        return voteDao.countByArticleIdAndVoteTypeId(articleDto.getId(), voteTypeDao.findByName("DOWN").getId());
    }

    public Long starCount(ArticleDto articleDto) {
        return voteDao.countByArticleIdAndVoteTypeId(articleDto.getId(), voteTypeDao.findByName("STAR").getId());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ArticleResolver(final ArticleDao articleDao, final ImageDao imageDao, final ThreadDao threadDao, final UserDao userDao, final VoteDao voteDao, final VoteTypeDao voteTypeDao) {
        this.articleDao = articleDao;
        this.imageDao = imageDao;
        this.threadDao = threadDao;
        this.userDao = userDao;
        this.voteDao = voteDao;
        this.voteTypeDao = voteTypeDao;
    }
    //</editor-fold>
}