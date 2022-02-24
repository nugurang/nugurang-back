package com.nugurang.graphql.resolver

import com.nugurang.dao.ImageDao
import com.nugurang.dao.MatchRequestDao
import com.nugurang.dto.EventDto
import com.nugurang.dto.ImageDto
import com.nugurang.dto.MatchRequestDto
import com.nugurang.dto.TagDto
import com.nugurang.mapper.MatchRequestMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class EventResolver(
    private val imageDao: ImageDao,
    private val matchRequestDao: MatchRequestDao,
    private val matchRequestMapper: MatchRequestMapper
) : GraphQLResolver<EventDto> {

    fun images(eventDto: EventDto): List<ImageDto> {
        return listOf()
    }

    fun tags(eventDto: EventDto?): List<TagDto> {
        return listOf()
    }

    fun matchRequests(eventDto: EventDto): List<MatchRequestDto> {
        return matchRequestDao.findAllByEventId(eventDto.id).map(matchRequestMapper::toDto)
    }
}