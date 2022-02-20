package com.nugurang.entity

import com.nugurang.dto.UserEvaluationDto
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

    @OneToOne(mappedBy = "userEvaluation")
    var project: ProjectEntity? = null
) : BaseEntity<UserEvaluationDto> {

    @PreRemove
    private fun preRemove() {
        if (project != null) project!!.userEvaluation = null
    }

    override fun toDto(): UserEvaluationDto {
        return UserEvaluationDto(id!!, createdAt!!, expiresAt!!)
    }
}