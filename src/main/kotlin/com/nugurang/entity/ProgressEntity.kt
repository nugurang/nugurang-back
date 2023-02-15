package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "progress")
class ProgressEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String
)