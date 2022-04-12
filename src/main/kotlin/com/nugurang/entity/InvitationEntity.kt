package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(
    name = "invitation",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["from_user", "to_user", "group"])
    ]
)
class InvitationEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var status: InvitationStatusEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var fromUser: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var toUser: UserEntity,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var group: GroupEntity,
)