package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.constant.InvitationStatusName
import com.nugurang.constant.RoleName
import com.nugurang.dao.*
import com.nugurang.dto.InvitationInputDto
import com.nugurang.entity.*
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Validated
@Service
class InvitationService(
    val notificationService: NotificationService,
    val userService: UserService,
    val groupDao: GroupDao,
    val invitationDao: InvitationDao,
    val invitationStatusDao: InvitationStatusDao,
    val roleDao: RoleDao,
    val xrefUserProjectDao: XrefUserProjectDao,
    val xrefUserTeamDao: XrefUserTeamDao
) {
    @DaoOp
    fun createInvitations(@Valid invitationInputDto: InvitationInputDto): List<InvitationEntity> {
        val currentUserEntity = userService.getCurrentUser()
        return invitationInputDto.users
        .map { userId -> userService.getUser(userId) }
        .map { userEntity ->
            val invitationEntity = invitationDao.save(
                InvitationEntity(
                    status = invitationStatusDao.findByName(InvitationStatusName.UNACCEPTED.name)
                        ?: throw NotFoundException(InvitationStatusEntity::class.java),
                    group = groupDao.findByIdOrNull(invitationInputDto.group)
                        ?: throw NotFoundException(GroupEntity::class.java),
                    fromUser = currentUserEntity,
                    toUser = userEntity
                )
            )
            notificationService.createInvitationNotification(userEntity, invitationEntity)
            return@map invitationEntity
        }
    }

    @DaoOp
    fun updateInvitationAccepted(invitationId: Long) {
        val invitationEntity = invitationDao.findByIdOrNull(invitationId)
            ?: throw NotFoundException(InvitationEntity::class.java)
        invitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.ACCEPTED.name)
            ?: throw NotFoundException(InvitationStatusEntity::class.java)
        invitationDao.save(invitationEntity)
        when (invitationEntity.group) {
            is ProjectEntity -> {
                xrefUserProjectDao.save(
                    XrefUserProjectEntity(
                        user = invitationEntity.toUser,
                        project = invitationEntity.group as ProjectEntity,
                        role = roleDao.findByName(RoleName.MEMBER.name) ?: throw NotFoundException(RoleEntity::class.java)
                    )
                )
            }
            is TeamEntity -> {
                xrefUserTeamDao.save (
                    XrefUserTeamEntity(
                        user = invitationEntity.toUser,
                        team = invitationEntity.group as TeamEntity,
                        role = roleDao.findByName(RoleName.MEMBER.name) ?: throw NotFoundException(RoleEntity::class.java)
                    )
                )
            }
            else -> {
                throw RuntimeException("Unknown Group Type")
            }
        }
    }

    @DaoOp
    fun updateInvitationDenied(invitationId: Long) {
        val invitationEntity = invitationDao.findByIdOrNull(invitationId) ?: throw NotFoundException(InvitationEntity::class.java)
        invitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.DENIED.name)
            ?: throw NotFoundException(InvitationStatusEntity::class.java)
        invitationDao.save(invitationEntity)
    }
}