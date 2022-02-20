package com.nugurang.entity

import com.nugurang.dto.PositionDto
import javax.persistence.*

@Entity
@Table(name = "position")
class PositionEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,

    @Column(nullable = true)
    var description: String? = null,

    @ManyToOne
    @JoinColumn(name = "image", nullable = true)
    var image: ImageEntity? = null

): BaseEntity<PositionDto?> {
    override fun toDto(): PositionDto {
        return PositionDto(id!!, name, description)
    }
}