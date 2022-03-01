package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(
    name = "project_invitation",
    uniqueConstraints = [UniqueConstraint(columnNames = ["project", "from_user", "to_user"])]
)
class ProjectInvitationEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    var status: InvitationStatusEntity,

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    var project: ProjectEntity,

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    var fromUser: UserEntity,

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    var toUser: UserEntity
)