package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_user_team", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "team"])])
class XrefUserTeamEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "team", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var team: TeamEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "role", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var role: RoleEntity
)