package com.nugurang.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "team")
class TeamEntity(
    @Column(nullable = false, unique = true)
    var name: String
) : GroupEntity()