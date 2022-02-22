package com.nugurang.entity

import com.nugurang.dto.ArticleDto
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

    @ManyToOne
    @JoinColumn(name = "thread", nullable = false)
    var thread: ThreadEntity,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity? = null,

    @ManyToOne
    @JoinColumn(name = "parent")
    var parent: ArticleEntity? = null

) : BaseEntity<ArticleDto> {
    override fun toDto(): ArticleDto {
        return ArticleDto(
            id!!,
            title,
            content,
            createdAt!!,
            modifiedAt!!
        )
    }
}