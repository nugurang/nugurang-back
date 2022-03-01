package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "team")
class TeamEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,

    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL])
    var projects: MutableList<ProjectEntity> = mutableListOf(),

    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL])
    var xrefUsers: MutableList<XrefUserTeamEntity> = mutableListOf()

)