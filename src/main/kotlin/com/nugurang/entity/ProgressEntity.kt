package com.nugurang.entity

import com.nugurang.dto.ProgressDto
import javax.persistence.*

@Entity
@Table(name = "progress")
class ProgressEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,
    @Column(nullable = false, unique = true)
    var name: String
): BaseEntity<ProgressDto> {
    override fun toDto(): ProgressDto {
        return ProgressDto(id!!, name)
    }
}