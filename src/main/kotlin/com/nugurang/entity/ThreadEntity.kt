package com.nugurang.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "thread")
class ThreadEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: OffsetDateTime? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var modifiedAt: OffsetDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    var board: BoardEntity,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "xref_user_team")
    var xrefUserTeam: XrefUserTeamEntity? = null,

    @ManyToOne
    @JoinColumn(name = "event")
    var event: EventEntity? = null,

    @OneToMany(mappedBy = "thread", cascade = [CascadeType.ALL])
    var xrefTags: MutableList<XrefThreadTagEntity> = mutableListOf()

)