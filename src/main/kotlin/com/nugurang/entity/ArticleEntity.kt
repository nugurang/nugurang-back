package com.nugurang.entity

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "article")
class ArticleEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    var title: String? = null,

    @Column(nullable = false)
    var content: String,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: OffsetDateTime? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var modifiedAt: OffsetDateTime? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "thread", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var thread: ThreadEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "parent")
    @OnDelete(action = OnDeleteAction.CASCADE)
    var parent: ArticleEntity? = null
)