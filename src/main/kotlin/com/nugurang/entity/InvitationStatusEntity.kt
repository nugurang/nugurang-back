package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "invitation_status")
class InvitationStatusEntity(
    @Id
    @GeneratedValue
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String,
)