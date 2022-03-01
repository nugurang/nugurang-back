package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "vote_type")
class VoteTypeEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String
)