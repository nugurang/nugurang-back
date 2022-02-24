package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "match_type")
class MatchTypeEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String
)