package com.nugurang.dao

import com.nugurang.entity.ImageEntity

interface ImageDaoCustom {
    fun findAllByArticleId(article: Long): List<ImageEntity>
}