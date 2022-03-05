package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var task: TaskEntity
)