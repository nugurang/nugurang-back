package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var type: MatchTypeEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var event: EventEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity
)