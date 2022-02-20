package com.nugurang.dao

import com.nugurang.entity.ArticleEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleDao : JpaRepository<ArticleEntity, Long> {
    fun findFirstByThreadIdOrderByCreatedAtAsc(thread: Long): ArticleEntity?
    fun countByThreadId(thread: Long): Long
    fun findAllByThreadIdOrderByCreatedAtAsc(thread: Long, pageable: Pageable): Page<ArticleEntity>
    fun findAllByUserId(user: Long, pageable: Pageable): Page<ArticleEntity>
}