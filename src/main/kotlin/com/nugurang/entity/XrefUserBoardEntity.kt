package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "xref_user_board", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "board"])])
class XrefUserBoardEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    var board: BoardEntity,

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    var role: RoleEntity
)