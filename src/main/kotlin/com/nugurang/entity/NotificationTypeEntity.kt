package com.nugurang.entity

import com.nugurang.dto.NotificationTypeDto
import javax.persistence.*

@Entity
@Table(name = "notification_type")
class NotificationTypeEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String
)