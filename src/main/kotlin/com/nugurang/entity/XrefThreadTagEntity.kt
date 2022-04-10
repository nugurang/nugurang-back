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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thread", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var thread: ThreadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var tag: TagEntity
)