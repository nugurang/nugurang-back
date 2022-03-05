package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "user_honor", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "position"])])
class UserHonorEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var honor: Int,

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: UserEntity,

    @ManyToOne(optional = false)
    @JoinColumn(name = "position", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var position: PositionEntity

)