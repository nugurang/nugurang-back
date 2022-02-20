package com.nugurang.service

import com.nugurang.dao.BoardDao
import com.nugurang.dao.ImageDao
import com.nugurang.dao.UserDao
import com.nugurang.dto.UserInputDto
import com.nugurang.entity.BoardEntity
import com.nugurang.entity.ImageEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val boardDao: BoardDao,
    private val imageDao: ImageDao,
    private val userDao: UserDao,
    private val oauth2Service: OAuth2Service
) {
    fun createUser(userInputDto: UserInputDto): UserEntity {
        return userDao.save(
            UserEntity(
                oauth2Provider = oauth2Service.getProvider(),
                oauth2Id = oauth2Service.getId(),
                name = userInputDto.name,
                email = userInputDto.email,
                biography = userInputDto.biography,
                image = userInputDto.image?.let { id ->
                    imageDao.findByIdOrNull(id) ?: throw NotFoundException(ImageEntity::class.java)
                },
                blog = boardDao.save(
                    BoardEntity(
                        name = UUID.randomUUID().toString()
                    )
                )
            )
        )
    }

    fun getUser(userId: Long): UserEntity {
        return userDao.findByIdOrNull(userId) ?: throw NotFoundException(UserEntity::class.java)
    }

    fun getUser(userName: String): UserEntity {
        return userDao.findByName(userName) ?: throw NotFoundException(UserEntity::class.java)
    }

    fun getCurrentUser(): UserEntity {
        return userDao
            .findByOauth2ProviderAndOauth2Id(oauth2Service.getProvider(), oauth2Service.getId())
            ?: throw NotFoundException(UserEntity::class.java)
    }

    fun getUsers(pageable: Pageable): List<UserEntity> {
        return userDao.findAll(pageable).content
    }

    fun getUsers(userName: String, pageable: Pageable): List<UserEntity> {
        return userDao.findAllByNameContainingIgnoreCase(userName, pageable).content
    }

    private fun updateUser(userInputDto: UserInputDto, userEntity: UserEntity): UserEntity {
        userEntity.name = userInputDto.name
        userEntity.email = userInputDto.email
        userEntity.biography = userInputDto.biography
        userEntity.image = userInputDto.image?.let { imageId ->
            imageDao.findByIdOrNull(imageId) ?: throw NotFoundException(ImageEntity::class.java)
        }
        return userDao.save(userEntity)
    }

    fun updateUser(userInputDto: UserInputDto, userId: Long): UserEntity {
        return updateUser(
            userInputDto,
            userDao.findByIdOrNull(userId) ?: throw NotFoundException(UserEntity::class.java)
        )
    }

    fun updateCurrentUser(userInputDto: UserInputDto): UserEntity {
        return updateUser(userInputDto, getCurrentUser())
    }

    fun deleteUser(userEntity: UserEntity): Long {
        val userId = userEntity.id!!
        userDao.delete(userEntity)
        return userId
    }

    fun deleteUser(userId: Long): Long {
        userDao.deleteById(userId)
        return userId
    }

    fun deleteCurrentUser(): Long {
        return deleteUser(getCurrentUser())
    }
}