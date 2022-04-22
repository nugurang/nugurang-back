package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "project", uniqueConstraints = [UniqueConstraint(columnNames = ["team", "name"])])
class ProjectEntity(
    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var finished: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team", nullable = false)
    var team: TeamEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event")
    var event: EventEntity? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_evaluation", unique = true)
    var userEvaluation: UserEvaluationEntity? = null
) : GroupEntity()