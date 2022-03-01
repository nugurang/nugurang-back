package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "project", uniqueConstraints = [UniqueConstraint(columnNames = ["team", "name"])])
class ProjectEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var finished: Boolean,

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    var team: TeamEntity,

    @ManyToOne
    @JoinColumn(name = "event")
    var event: EventEntity? = null,

    @OneToOne
    @JoinColumn(name = "user_evaluation", unique = true)
    var userEvaluation: UserEvaluationEntity? = null

)