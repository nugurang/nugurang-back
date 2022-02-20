package com.nugurang.entity

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
    var notification: NotificationEntity

)