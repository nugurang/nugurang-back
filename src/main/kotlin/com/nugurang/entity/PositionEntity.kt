package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "position")
class PositionEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,

    @Column(nullable = true)
    var description: String? = null,

    // TODO: ON DELETE SET NULL
    @ManyToOne
    @JoinColumn(name = "image", nullable = true)
    var image: ImageEntity? = null
)