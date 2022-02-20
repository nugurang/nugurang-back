package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_thread_tag", uniqueConstraints = [UniqueConstraint(columnNames = ["thread", "tag"])])
class XrefThreadTagEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "thread", nullable = false)
    var thread: ThreadEntity,

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    var tag: TagEntity
)