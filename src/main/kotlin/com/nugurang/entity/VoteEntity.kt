package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "vote", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "article", "vote_type"])])
class VoteEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "article", nullable = false)
    var article: ArticleEntity,

    @ManyToOne
    @JoinColumn(name = "vote_type", nullable = false)
    var voteType: VoteTypeEntity

)