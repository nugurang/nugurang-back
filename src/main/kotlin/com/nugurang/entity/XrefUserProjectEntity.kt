package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_user_project", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "project"])])
class XrefUserProjectEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    var project: ProjectEntity,

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    var role: RoleEntity
)