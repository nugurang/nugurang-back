package com.nugurang.dao

import com.nugurang.entity.ImageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageDao : JpaRepository<ImageEntity, Long>, ImageDaoCustom {
    fun findByAddress(address: String): ImageEntity?
}