package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_article_image", uniqueConstraints = [UniqueConstraint(columnNames = ["article", "image"])])
class XrefArticleImageEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "article", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var article: ArticleEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "image", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var image: ImageEntity
)