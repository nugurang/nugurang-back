package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_article_tag", uniqueConstraints = [UniqueConstraint(columnNames = ["article", "tag"])])
class XrefArticleTagEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    var article: ArticleEntity,

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    var tag: TagEntity
)