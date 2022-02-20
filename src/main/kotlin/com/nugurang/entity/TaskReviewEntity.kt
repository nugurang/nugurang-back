package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "task_review", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "task"])])
class TaskReviewEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var honor: Int,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    var task: TaskEntity
)