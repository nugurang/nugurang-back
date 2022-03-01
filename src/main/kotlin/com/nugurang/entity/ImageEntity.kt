package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "image")
class ImageEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var address: String
)