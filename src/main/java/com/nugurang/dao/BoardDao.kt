package com.nugurang.dao

import com.nugurang.entity.BoardEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardDao : JpaRepository<BoardEntity, Long> {
    fun findByName(name: String): BoardEntity?
    fun findAllByNameIn(names: List<String>): List<BoardEntity>
}