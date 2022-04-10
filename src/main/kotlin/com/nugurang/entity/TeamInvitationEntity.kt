package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "team_invitation", uniqueConstraints = [UniqueConstraint(columnNames = ["team", "from_user", "to_user"])])
class TeamInvitationEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var status: InvitationStatusEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var team: TeamEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var fromUser: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var toUser: UserEntity,

)