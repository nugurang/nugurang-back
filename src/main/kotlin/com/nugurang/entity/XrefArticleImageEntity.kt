package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_article_image", uniqueConstraints = [UniqueConstraint(columnNames = ["article", "image"])])
class XrefArticleImageEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    var article: ArticleEntity,

    @ManyToOne
    @JoinColumn(name = "image", nullable = false)
    var image: ImageEntity
)