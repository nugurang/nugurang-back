package com.nugurang.entity

import javax.persistence.*

// TODO: Remove role and use spring security ACL
@Entity
@Table(name = "role")
class RoleEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String
)