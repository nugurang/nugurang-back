package com.nugurang.dao

import com.nugurang.entity.TagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TagDao : JpaRepository<TagEntity, Long>