package com.nugurang.entity

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "user_evaluation")
class UserEvaluationEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var createdAt: OffsetDateTime? = null,

    @Column(nullable = false)
    var expiresAt: OffsetDateTime? = null,

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userEvaluation")
    var project: ProjectEntity? = null
) {
    @PreRemove
    private fun preRemove() {
        project?.let { it.userEvaluation = null }
    }
}