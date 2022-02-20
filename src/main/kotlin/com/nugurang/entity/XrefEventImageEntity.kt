package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_event_image", uniqueConstraints = [UniqueConstraint(columnNames = ["event", "image"])])
class XrefEventImageEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    var event: EventEntity,

    @ManyToOne
    @JoinColumn(name = "image", nullable = false)
    var image: ImageEntity
)