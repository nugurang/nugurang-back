package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_event_image", uniqueConstraints = [UniqueConstraint(columnNames = ["event", "image"])])
class XrefEventImageEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var event: EventEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var image: ImageEntity
)