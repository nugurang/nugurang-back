package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_user_task", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "task"])])
class XrefUserTaskEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    var task: TaskEntity
)