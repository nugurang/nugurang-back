package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "group")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class GroupEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
)