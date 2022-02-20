package com.nugurang.entity

import com.nugurang.dto.ImageDto
import javax.persistence.*

@Entity
@Table(name = "image")
class ImageEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var address: String

): BaseEntity<ImageDto> {
    override fun toDto(): ImageDto {
        return ImageDto(id!!, address)
    }
}