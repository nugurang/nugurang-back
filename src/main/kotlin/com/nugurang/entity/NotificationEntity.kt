package com.nugurang.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "notification")
class NotificationEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var isRead: Boolean,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: OffsetDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "notification_type", nullable = false)
    var notificationType: NotificationTypeEntity,

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    var user: UserEntity
)