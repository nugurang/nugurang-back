package com.nugurang.config

import com.nugurang.constant.*
import com.nugurang.dao.*
import com.nugurang.entity.*
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class DbInitConfig(
    private val invitationStatusDao: InvitationStatusDao,
    private val matchTypeDao: MatchTypeDao,
    private val notificationTypeDao: NotificationTypeDao,
    private val progressDao: ProgressDao,
    private val roleDao: RoleDao,
    private val voteTypeDao: VoteTypeDao
) {
    @PostConstruct
    fun init() {
        for (invitationStatusName in InvitationStatusName.values()) {
            invitationStatusDao.save(
                InvitationStatusEntity(name = invitationStatusName.name)
            )
        }
        for (roleName in listOf(RoleName.OWNER.name, RoleName.MEMBER.name)) {
            roleDao.save(
                RoleEntity(name = roleName)
            )
        }
        for (voteTypeName in VoteTypeName.values()) {
            voteTypeDao.save(
                VoteTypeEntity(name = voteTypeName.name)
            )
        }
        for (progressName in ProgressName.values()) {
            progressDao.save(
                ProgressEntity(name = progressName.name)
            )
        }
        for (matchTypeName in MatchTypeName.values()) {
            matchTypeDao.save(
                MatchTypeEntity(name = matchTypeName.name)
            )
        }
        for (notificationTypeName in NotificationTypeName.values()) {
            notificationTypeDao.save(
                NotificationTypeEntity(name = notificationTypeName.name)
            )
        }
    }
}