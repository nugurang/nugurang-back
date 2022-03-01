package com.nugurang.entity

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "match_request", uniqueConstraints = [UniqueConstraint(columnNames = ["event", "user"])])
class MatchRequestEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var createdAt: OffsetDateTime? = null,

    @Column(nullable = false)
    var expiresAt: OffsetDateTime? = null,

    @Column(nullable = false)
    var minTeamSize: Int,

    @Column(nullable = true)
    var maxTeamSize: Int? = null,

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    var type: MatchTypeEntity,

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    var event: EventEntity,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity
)