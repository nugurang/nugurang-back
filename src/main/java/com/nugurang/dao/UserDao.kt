package com.nugurang.dao

import com.nugurang.entity.UserEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<UserEntity, Long>, UserDaoCustom {
    override fun findAll(pageable: Pageable): Page<UserEntity>
    fun findAllByNameContainingIgnoreCase(name: String, pageable: Pageable): Page<UserEntity>
    fun findByOauth2ProviderAndOauth2Id(oauth2Provider: String, oauth2Id: String): UserEntity?
    fun findByName(name: String): UserEntity?
}