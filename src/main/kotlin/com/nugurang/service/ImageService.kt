package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.dao.ImageDao
import com.nugurang.entity.ImageEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ImageService(private val imageDao: ImageDao) {
    @DaoOp
    fun createImage(imageAddress: String): ImageEntity {
        return imageDao.save(ImageEntity(address = imageAddress))
    }

    fun getImage(id: Long): ImageEntity {
        return imageDao.findByIdOrNull(id) ?: throw NotFoundException(ImageEntity::class.java)
    }

    fun getImage(address: String): ImageEntity {
        return imageDao.findByAddress(address) ?: throw NotFoundException(ImageEntity::class.java)
    }

    @DaoOp
    fun deleteImage(id: Long) {
        imageDao.deleteById(id)
    }
}
