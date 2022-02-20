package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_task_position", uniqueConstraints = [UniqueConstraint(columnNames = ["task", "position"])])
class XrefTaskPositionEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "task", nullable = false)
    var task: TaskEntity,

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    var position: PositionEntity
)