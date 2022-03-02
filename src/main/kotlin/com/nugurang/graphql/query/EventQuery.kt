package com.nugurang.graphql.query

import com.nugurang.dto.EventDto
import com.nugurang.mapper.EventMapper
import com.nugurang.service.EventService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class EventQuery(
    private val eventService: EventService,
    private val eventMapper: EventMapper
) : GraphQLQueryResolver {

    fun getEvent(id: Long): EventDto {
        return eventService.getEvent(id).let(eventMapper::toDto)
    }
}