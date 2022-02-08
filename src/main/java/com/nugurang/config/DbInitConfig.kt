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
            invitationStatusDao.save(InvitationStatusEntity.builder().name(invitationStatusName.name).build())
        }
        for (roleName in listOf(RoleName.OWNER.name, RoleName.MEMBER.name)) roleDao.save(
            RoleEntity.builder().name(roleName).build()
        )
        for (voteTypeName in VoteTypeName.values()) voteTypeDao.save(
            VoteTypeEntity.builder().name(voteTypeName.name).build()
        )
        for (progressName in ProgressName.values()) progressDao.save(
            ProgressEntity.builder().name(progressName.name).build()
        )
        for (matchTypeName in MatchTypeName.values()) matchTypeDao.save(
            MatchTypeEntity.builder().name(matchTypeName.name).build()
        )
        for (notificationTypeName in NotificationTypeName.values()) {
            notificationTypeDao.save(NotificationTypeEntity.builder().name(notificationTypeName.name).build())
        }
    }
}