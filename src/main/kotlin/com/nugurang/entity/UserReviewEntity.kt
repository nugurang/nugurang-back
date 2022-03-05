package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "position", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var position: PositionEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "from_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var fromUser: UserEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "to_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var toUser: UserEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_evaluation", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var userEvaluation: UserEvaluationEntity

)