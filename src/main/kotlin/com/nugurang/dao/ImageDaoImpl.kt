package com.nugurang.dao

import com.nugurang.entity.ImageEntity
import com.nugurang.entity.QImageEntity
import com.nugurang.entity.QXrefArticleImageEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ImageDaoImpl(private val queryFactory: JPAQueryFactory) : ImageDaoCustom {
    override fun findAllByArticleId(article: Long): List<ImageEntity> {
        return queryFactory.selectFrom(QImageEntity.imageEntity)
            .innerJoin(QXrefArticleImageEntity.xrefArticleImageEntity)
            .on(QImageEntity.imageEntity.id.eq(QXrefArticleImageEntity.xrefArticleImageEntity.image.id))
            .where(QXrefArticleImageEntity.xrefArticleImageEntity.article.id.eq(article)).fetch()
    }
}