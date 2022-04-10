package com.nugurang.entity

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*

@Entity
@Table(name = "vote", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "article", "vote_type"])])
class VoteEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var article: ArticleEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_type", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var voteType: VoteTypeEntity

)