package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var status: InvitationStatusEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var project: ProjectEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var fromUser: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var toUser: UserEntity
)