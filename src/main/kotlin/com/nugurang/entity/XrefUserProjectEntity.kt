package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_user_project", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "project"])])
class XrefUserProjectEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var project: ProjectEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var role: RoleEntity
)