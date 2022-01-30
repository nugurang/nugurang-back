package com.nugurang.dao

import com.nugurang.entity.ThreadEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ThreadDao : JpaRepository<ThreadEntity, Long>, ThreadDaoCustom {
    fun findAllByBoardIdInOrderByCreatedAtDesc(boards: List<Long>, pageable: Pageable): Page<ThreadEntity>
    fun findAllByBoardIdOrderByCreatedAtDesc(board: Long, pageable: Pageable): Page<ThreadEntity>
    fun findAllByBoardNameInOrderByCreatedAtDesc(boards: List<String>, pageable: Pageable): Page<ThreadEntity>
    fun findAllByUserId(user: Long, pageable: Pageable): Page<ThreadEntity>
}