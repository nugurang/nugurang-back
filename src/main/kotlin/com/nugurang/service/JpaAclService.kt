package com.nugurang.service

import org.springframework.security.acls.model.*

open class JpaAclService : AclService {
    override fun findChildren(parentIdentity: ObjectIdentity): List<ObjectIdentity>? {
        return null
    }

    @Throws(NotFoundException::class)
    override fun readAclById(`object`: ObjectIdentity): Acl? {
        return null
    }

    @Throws(NotFoundException::class)
    override fun readAclById(`object`: ObjectIdentity, sids: List<Sid>): Acl? {
        return null
    }

    @Throws(NotFoundException::class)
    override fun readAclsById(objects: List<ObjectIdentity>): Map<ObjectIdentity, Acl>? {
        return null
    }

    @Throws(NotFoundException::class)
    override fun readAclsById(objects: List<ObjectIdentity>, sids: List<Sid>): Map<ObjectIdentity, Acl>? {
        return null
    }
}