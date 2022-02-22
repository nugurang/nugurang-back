package com.nugurang.entity

import com.nugurang.dto.UserDto
import javax.persistence.*

@Entity
@Table(name = "user", uniqueConstraints = [UniqueConstraint(columnNames = ["oauth2_provider", "oauth2_id"])])
class UserEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(name = "oauth2_provider", nullable = false)
    var oauth2Provider: String,

    @Column(name = "oauth2_id", nullable = false)
    var oauth2Id: String,

    @Column(nullable = false, unique = true)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

    var biography: String? = null,

    @OneToOne
    @JoinColumn(name = "blog")
    var blog: BoardEntity,

    @ManyToOne
    @JoinColumn(name = "image")
    var image: ImageEntity? = null

): BaseEntity<UserDto> {
    override fun toDto(): UserDto {
        return UserDto(id!!, oauth2Provider, oauth2Id, name, email, biography)
    }
}