package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_event_tag", uniqueConstraints = [UniqueConstraint(columnNames = ["event", "tag"])])
class XrefEventTagEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "event", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var event: EventEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "tag", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var tag: TagEntity
)