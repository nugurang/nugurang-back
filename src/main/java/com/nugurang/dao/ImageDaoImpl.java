package com.nugurang.dao;

import static com.nugurang.entity.QImageEntity.imageEntity;
import static com.nugurang.entity.QXrefArticleImageEntity.xrefArticleImageEntity;
import com.nugurang.entity.ImageEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl implements ImageDaoCustom {
    private final JPAQueryFactory queryFactory;

    public List<ImageEntity> findAllByArticleId(Long article) {
        return queryFactory.selectFrom(imageEntity).innerJoin(xrefArticleImageEntity).on(imageEntity.id.eq(xrefArticleImageEntity.image.id)).where(xrefArticleImageEntity.article.id.eq(article)).fetch();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ImageDaoImpl(final JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
    //</editor-fold>
}
