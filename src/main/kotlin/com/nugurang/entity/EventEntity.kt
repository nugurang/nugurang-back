package com.nugurang.entity

import com.nugurang.dto.EventDto
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "event")
class EventEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var recruitingStart: OffsetDateTime,

    @Column(nullable = false)
    var recruitingEnd: OffsetDateTime,

    @Column(nullable = false)
    var eventStart: OffsetDateTime,

    @Column(nullable = false)
    var eventEnd: OffsetDateTime,

): BaseEntity<EventDto> {
    override fun toDto(): EventDto {
        return EventDto(
            id!!,
            name,
            description,
            recruitingStart,
            recruitingEnd,
            eventStart,
            eventEnd
        )
    }
}