package com.nugurang.service

import com.nugurang.dao.ImageDao
import com.nugurang.entity.ImageEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ImageService(private val imageDao: ImageDao) {

    fun createImage(imageAddress: String): ImageEntity {
        return imageDao.save(ImageEntity.builder().address(imageAddress).build())
    }

    fun getImage(id: Long): ImageEntity {
        return imageDao.findByIdOrNull(id) ?: throw NotFoundException(ImageEntity::class.java)
    }

    fun getImage(address: String): ImageEntity {
        return imageDao.findByAddress(address) ?: throw NotFoundException(ImageEntity::class.java)
    }

    fun deleteImage(id: Long) {
        imageDao.deleteById(id)
    }
}
