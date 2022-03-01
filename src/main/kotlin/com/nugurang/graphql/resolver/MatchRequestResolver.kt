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
import com.nugurang.mapper.EventMapper
import com.nugurang.mapper.MatchTypeMapper
import com.nugurang.mapper.UserMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MatchRequestResolver(
    private val matchRequestDao: MatchRequestDao,
    private val eventMapper: EventMapper,
    private val matchTypeMapper: MatchTypeMapper,
    private val userMapper: UserMapper
) : GraphQLResolver<MatchRequestDto> {
    fun type(matchRequestDto: MatchRequestDto): MatchTypeDto {
        return matchRequestDao.findByIdOrNull(matchRequestDto.id)?.type?.let(matchTypeMapper::toDto)
            ?: throw NotFoundException(MatchTypeEntity::class.java)
    }

    fun event(matchRequestDto: MatchRequestDto): EventDto {
        return matchRequestDao.findByIdOrNull(matchRequestDto.id)?.event?.let(eventMapper::toDto)
            ?: throw NotFoundException(EventEntity::class.java)
    }

    fun user(matchRequestDto: MatchRequestDto): UserDto {
        return matchRequestDao.findByIdOrNull(matchRequestDto.id)?.user?.let(userMapper::toDto)
            ?: throw NotFoundException(UserEntity::class.java)
    }
}