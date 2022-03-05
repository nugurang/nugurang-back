package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "xref_user_board", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "board"])])
class XrefUserBoardEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "board", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var board: BoardEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "role", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var role: RoleEntity
)