package com.nugurang.dao

import com.nugurang.entity.XrefArticleImageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XrefArticleImageDao : JpaRepository<XrefArticleImageEntity, Long>