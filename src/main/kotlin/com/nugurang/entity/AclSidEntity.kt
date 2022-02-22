package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "acl_sid", uniqueConstraints = [UniqueConstraint(columnNames = ["sid", "principal"])])
class AclSidEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var principal: Boolean,

    @Column(nullable = false)
    var sid: String
)