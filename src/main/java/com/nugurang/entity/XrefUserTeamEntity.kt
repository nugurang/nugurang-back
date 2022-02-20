package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_user_team", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "team"])])
class XrefUserTeamEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    var team: TeamEntity,

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    var role: RoleEntity
)