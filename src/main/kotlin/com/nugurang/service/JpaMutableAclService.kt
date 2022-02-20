package com.nugurang.service

import org.springframework.security.acls.model.*

class JpaMutableAclService : JpaAclService(), MutableAclService {
    @Throws(AlreadyExistsException::class)
    override fun createAcl(objectIdentity: ObjectIdentity): MutableAcl? {
        return null
    }

    @Throws(ChildrenExistException::class)
    override fun deleteAcl(objectIdentity: ObjectIdentity, deleteChildren: Boolean) {
    }

    @Throws(NotFoundException::class)
    override fun updateAcl(acl: MutableAcl): MutableAcl? {
        return null
    }
}