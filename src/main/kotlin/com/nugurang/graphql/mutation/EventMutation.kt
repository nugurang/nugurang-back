package com.nugurang.graphql.mutation

import com.nugurang.dto.EventDto
import com.nugurang.dto.EventInputDto
import com.nugurang.mapper.EventMapper
import com.nugurang.service.EventService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class EventMutation(
    private val eventService: EventService,
    private val eventMapper: EventMapper
) : GraphQLMutationResolver {

    fun createEvent(eventInputDto: EventInputDto): EventDto {
        return eventService.createEvent(eventInputDto).let(eventMapper::toDto)
    }

    fun updateEvent(eventInputDto: EventInputDto, eventId: Long): EventDto {
        return eventService.updateEvent(eventInputDto, eventId).let(eventMapper::toDto)
    }

    fun deleteEvent(eventId: Long): Long {
        eventService.deleteEvent(eventId)
        return eventId
    }
}