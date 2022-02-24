package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "following", uniqueConstraints = [UniqueConstraint(columnNames = ["from_user", "to_user"])])
class FollowingEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    var fromUser: UserEntity,

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    var toUser: UserEntity
)