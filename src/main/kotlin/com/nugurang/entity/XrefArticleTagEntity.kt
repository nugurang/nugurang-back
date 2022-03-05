package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_article_tag", uniqueConstraints = [UniqueConstraint(columnNames = ["article", "tag"])])
class XrefArticleTagEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var article: ArticleEntity,

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var tag: TagEntity
)