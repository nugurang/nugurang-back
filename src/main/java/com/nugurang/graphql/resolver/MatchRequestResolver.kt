package com.nugurang.graphql.resolver

import com.nugurang.dao.MatchRequestDao
import com.nugurang.dto.EventDto
import com.nugurang.dto.MatchRequestDto
import com.nugurang.dto.MatchTypeDto
import com.nugurang.dto.UserDto
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class MatchRequestResolver(private val matchRequestDao: MatchRequestDao) : GraphQLResolver<MatchRequestDto> {
    fun type(matchRequestDto: MatchRequestDto): MatchTypeDto {
        return matchRequestDao.findById(matchRequestDto.id).get().type.toDto()
    }

    fun event(matchRequestDto: MatchRequestDto): EventDto {
        return matchRequestDao.findById(matchRequestDto.id).get().event.toDto()
    }

    fun user(matchRequestDto: MatchRequestDto): UserDto {
        return matchRequestDao.findById(matchRequestDto.id).get().user.toDto()
    }
}