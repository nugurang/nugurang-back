package com.nugurang.entity

import com.nugurang.dto.MatchTypeDto
import javax.persistence.*

@Entity
@Table(name = "match_type")
class MatchTypeEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String
    
): BaseEntity<MatchTypeDto> {
    override fun toDto(): MatchTypeDto {
        return MatchTypeDto(id!!, name)
    }
}