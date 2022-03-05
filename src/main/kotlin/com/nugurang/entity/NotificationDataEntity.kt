package com.nugurang.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "notification_data")
class NotificationDataEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false)
    var value: String,

    @ManyToOne
    @JoinColumn(name = "notification", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var notification: NotificationEntity
)