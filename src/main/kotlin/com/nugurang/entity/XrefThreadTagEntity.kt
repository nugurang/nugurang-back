package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_thread_tag", uniqueConstraints = [UniqueConstraint(columnNames = ["thread", "tag"])])
class XrefThreadTagEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "thread", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var thread: ThreadEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "tag", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var tag: TagEntity
)