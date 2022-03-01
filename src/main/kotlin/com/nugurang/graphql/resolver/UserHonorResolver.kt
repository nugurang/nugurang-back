package com.nugurang.graphql.resolver

import com.nugurang.dao.UserHonorDao
import com.nugurang.dto.PositionDto
import com.nugurang.dto.UserDto
import com.nugurang.dto.UserHonorDto
import com.nugurang.entity.UserHonorEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.PositionMapper
import com.nugurang.mapper.UserMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserHonorResolver(
    private val userHonorDao: UserHonorDao,
    private val positionMapper: PositionMapper,
    private val userMapper: UserMapper
) : GraphQLResolver<UserHonorDto> {

    fun user(userHonorDto: UserHonorDto): UserDto {
        return userHonorDao
        .findByIdOrNull(userHonorDto.id)
        ?.let { it.user }
        ?.let(userMapper::toDto)
        ?: throw NotFoundException(UserHonorEntity::class.java)
    }

    fun position(userHonorDto: UserHonorDto): PositionDto {
        return userHonorDao
        .findByIdOrNull(userHonorDto.id)
        ?.let { it.position }
        ?.let(positionMapper::toDto)
        ?: throw NotFoundException(UserHonorEntity::class.java)
    }
}