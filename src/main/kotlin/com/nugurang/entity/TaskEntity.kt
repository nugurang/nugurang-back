package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(
    name = "task",
    uniqueConstraints = [UniqueConstraint(columnNames = ["work", "name"]), UniqueConstraint(columnNames = ["work", "name", "order"])]
)
class TaskEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,

    @Column(nullable = false, unique = true)
    var order: Int,

    @Column(nullable = false)
    var difficulty: Int,

    @ManyToOne
    @JoinColumn(name = "work", nullable = false)
    var work: WorkEntity,

    @ManyToOne
    @JoinColumn(name = "progress", nullable = false)
    var progress: ProgressEntity

)