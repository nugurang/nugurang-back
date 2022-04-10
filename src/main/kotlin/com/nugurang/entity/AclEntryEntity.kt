package com.nugurang.entity

import javax.persistence.*

@Entity
@Table(name = "acl_entry", uniqueConstraints = [UniqueConstraint(columnNames = ["acl_object_identity", "ace_order"])])
class AclEntryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acl_object_identity", nullable = false)
    var aclObjectIdentity: AclObjectIdentityEntity,

    @Column(name = "ace_order", nullable = false)
    var aceOrder: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sid", nullable = false)
    var sid: AclSidEntity,

    @Column(nullable = false)
    var mask: Int,

    @Column(nullable = false)
    var granting: Boolean,

    @Column(nullable = false)
    var auditSuccess: Boolean,

    @Column(nullable = false)
    var auditFailure: Boolean,
)