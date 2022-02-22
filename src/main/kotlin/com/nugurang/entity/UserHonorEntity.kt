package com.nugurang.entity

import com.nugurang.dto.UserHonorDto
import javax.persistence.*

@Entity
@Table(name = "user_honor", uniqueConstraints = [UniqueConstraint(columnNames = ["user", "position"])])
class UserHonorEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var honor: Int,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    var position: PositionEntity

) : BaseEntity<UserHonorDto> {
    override fun toDto(): UserHonorDto {
        return UserHonorDto(id!!, honor)
    }
}