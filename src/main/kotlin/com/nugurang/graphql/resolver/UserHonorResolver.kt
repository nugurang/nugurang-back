package com.nugurang.graphql.resolver

import com.nugurang.dao.UserHonorDao
import com.nugurang.dto.PositionDto
import com.nugurang.dto.UserDto
import com.nugurang.dto.UserHonorDto
import com.nugurang.entity.PositionEntity
import com.nugurang.entity.UserEntity
import com.nugurang.entity.UserHonorEntity
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class UserHonorResolver(private val userHonorDao: UserHonorDao) : GraphQLResolver<UserHonorDto?> {
    fun user(userHonorDto: UserHonorDto): UserDto {
        return userHonorDao.findById(userHonorDto.id).map { userHonorEntity: UserHonorEntity -> userHonorEntity.user }
            .map { userEntity: UserEntity -> userEntity.toDto() }.get()
    }

    fun position(userHonorDto: UserHonorDto): PositionDto {
        return userHonorDao.findById(userHonorDto.id)
            .map { userHonorEntity: UserHonorEntity -> userHonorEntity.position }
            .map { positionEntity: PositionEntity -> positionEntity.toDto() }.get()
    }
}