package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_task_position", uniqueConstraints = [UniqueConstraint(columnNames = ["task", "position"])])
class XrefTaskPositionEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "task", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var task: TaskEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "position", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var position: PositionEntity
)