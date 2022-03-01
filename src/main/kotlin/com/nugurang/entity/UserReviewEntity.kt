package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(
    name = "user_review",
    uniqueConstraints = [UniqueConstraint(columnNames = ["position", "from_user", "to_user", "user_evaluation"])]
)
class UserReviewEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var honor: Int,

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    var position: PositionEntity,

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    var fromUser: UserEntity,

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    var toUser: UserEntity,

    @ManyToOne
    @JoinColumn(name = "user_evaluation", nullable = false)
    var userEvaluation: UserEvaluationEntity

)