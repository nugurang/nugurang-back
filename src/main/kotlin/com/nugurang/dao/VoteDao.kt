package com.nugurang.dao

import com.nugurang.entity.VoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VoteDao : JpaRepository<VoteEntity, Long> {
    fun countByArticleIdAndVoteTypeId(article: Long, voteType: Long): Long
    fun findByUserIdAndArticleIdAndVoteTypeName(
        user: Long,
        article: Long,
        voteTypeName: String
    ): VoteEntity?
}