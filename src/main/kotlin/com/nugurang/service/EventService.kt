package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.dao.EventDao
import com.nugurang.dto.EventInputDto
import com.nugurang.entity.EventEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class EventService(private val eventDao: EventDao) {
    @DaoOp
    fun createEvent(eventInputDto: EventInputDto): EventEntity {
        return eventDao.save(
            EventEntity(
                name = eventInputDto.name,
                description = eventInputDto.description,
                recruitingStart = eventInputDto.recruitingStart,
                recruitingEnd = eventInputDto.recruitingEnd,
                eventStart = eventInputDto.eventStart,
                eventEnd = eventInputDto.eventEnd
            )
        )
    }

    fun getEvent(eventId: Long): EventEntity {
        return eventDao.findByIdOrNull(eventId) ?: throw NotFoundException(EventEntity::class.java)
    }

    @DaoOp
    fun updateEvent(eventInputDto: EventInputDto, eventId: Long): EventEntity {
        val eventEntity = eventDao.findByIdOrNull(eventId) ?: throw NotFoundException(EventEntity::class.java)
        eventEntity.name = eventInputDto.name
        eventEntity.description = eventInputDto.description
        eventEntity.recruitingStart = eventInputDto.recruitingStart
        eventEntity.recruitingEnd = eventInputDto.recruitingEnd
        eventEntity.eventStart = eventInputDto.eventStart
        eventEntity.eventEnd = eventInputDto.eventEnd
        return eventDao.save(eventEntity)
    }

    @DaoOp
    fun deleteEvent(eventId: Long) {
        eventDao.deleteById(eventId)
    }
}