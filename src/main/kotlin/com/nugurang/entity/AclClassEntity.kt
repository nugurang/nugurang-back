package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "acl_class")
class AclClassEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "class", nullable = false, unique = true)
    var className: String
)