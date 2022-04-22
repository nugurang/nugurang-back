package com.nugurang.graphql.resolver

import com.nugurang.dao.InvitationDao
import com.nugurang.dto.GroupDto
import com.nugurang.dto.InvitationDto
import com.nugurang.dto.InvitationStatusDto
import com.nugurang.dto.UserDto
import com.nugurang.entity.GroupEntity
import com.nugurang.entity.InvitationStatusEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.GroupMapper
import com.nugurang.mapper.InvitationStatusMapper
import com.nugurang.mapper.UserMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class InvitationResolver(
    private val invitationDao: InvitationDao,
    private val invitationStatusMapper: InvitationStatusMapper,
    private val userMapper: UserMapper,
    private val groupMapper: GroupMapper
    ) : GraphQLResolver<InvitationDto> {

    fun group(invitationDto: InvitationDto): GroupDto {
        return invitationDao.findByIdOrNull(invitationDto.id)
        ?.group
        ?.let(groupMapper::toDto)
        ?: throw NotFoundException(GroupEntity::class.java)
    }

    fun status(invitationDto: InvitationDto): InvitationStatusDto {
        return invitationDao.findByIdOrNull(invitationDto.id)
        ?.let { invitationStatusMapper.toDto(it.status) }
        ?: throw NotFoundException(InvitationStatusEntity::class.java)
    }

    fun fromUser(invitationDto: InvitationDto): UserDto {
        return invitationDao.findByIdOrNull(invitationDto.id)
        ?.fromUser
        ?.let(userMapper::toDto)
        ?: throw NotFoundException(UserEntity::class.java)
    }

    fun toUser(invitationDto: InvitationDto): UserDto {
        return invitationDao.findByIdOrNull(invitationDto.id)
        ?.toUser
        ?.let(userMapper::toDto)
        ?: throw NotFoundException(UserEntity::class.java)
    }
}