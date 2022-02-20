package com.nugurang.entity

import com.nugurang.dto.BoardDto
import javax.persistence.*

@Entity
@Table(name = "board")
class BoardEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,

    @OneToMany(mappedBy = "board", cascade = [CascadeType.ALL])
    var xrefUsers: MutableList<XrefUserBoardEntity> = mutableListOf()

): BaseEntity<BoardDto> {
    override fun toDto(): BoardDto {
        return BoardDto(id!!, name)
    }
}