package com.nugurang.entity

import com.nugurang.dto.TeamInvitationDto
import javax.persistence.*

@Entity
@Table(name = "team_invitation", uniqueConstraints = [UniqueConstraint(columnNames = ["team", "from_user", "to_user"])])
class TeamInvitationEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    var status: InvitationStatusEntity,

    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    var team: TeamEntity,

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    var fromUser: UserEntity,

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    var toUser: UserEntity,

) : BaseEntity<TeamInvitationDto> {
    override fun toDto(): TeamInvitationDto {
        return TeamInvitationDto(id!!)
    }
}