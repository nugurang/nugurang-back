package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_event_tag", uniqueConstraints = [UniqueConstraint(columnNames = ["event", "tag"])])
class XrefEventTagEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    var event: EventEntity,

    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    var tag: TagEntity
)