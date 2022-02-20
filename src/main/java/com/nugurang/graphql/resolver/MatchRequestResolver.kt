package com.nugurang.graphql.resolver

import com.nugurang.dao.MatchRequestDao
import com.nugurang.dto.EventDto
import com.nugurang.dto.MatchRequestDto
import com.nugurang.dto.MatchTypeDto
import com.nugurang.dto.UserDto
import com.nugurang.entity.EventEntity
import com.nugurang.entity.MatchTypeEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MatchRequestResolver(private val matchRequestDao: MatchRequestDao) : GraphQLResolver<MatchRequestDto> {
    fun type(matchRequestDto: MatchRequestDto): MatchTypeDto {
        return matchRequestDao.findByIdOrNull(matchRequestDto.id)?.type?.toDto()
            ?: throw NotFoundException(MatchTypeEntity::class.java)
    }

    fun event(matchRequestDto: MatchRequestDto): EventDto {
        return matchRequestDao.findByIdOrNull(matchRequestDto.id)?.event?.toDto()
            ?: throw NotFoundException(EventEntity::class.java)

    }

    fun user(matchRequestDto: MatchRequestDto): UserDto {
        return matchRequestDao.findByIdOrNull(matchRequestDto.id)?.user?.toDto()
            ?: throw NotFoundException(UserEntity::class.java)
    }
}