package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(
    name = "acl_object_identity",
    uniqueConstraints = [UniqueConstraint(columnNames = ["object_id_class", "object_id_identity"])]
)
class AclObjectIdentityEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "object_id_class", nullable = false)
    var objectIdClass: AclClassEntity,

    @Column(name = "object_id_identity", nullable = false)
    var objectIdIdentity: Long,

    @ManyToOne
    @JoinColumn(name = "parent_object")
    var parentObject: AclObjectIdentityEntity? = null,

    @ManyToOne
    @JoinColumn(name = "owner_sid")
    var ownerSid: AclSidEntity? = null,

    @Column(nullable = false)
    var entriesInheriting: Boolean
)