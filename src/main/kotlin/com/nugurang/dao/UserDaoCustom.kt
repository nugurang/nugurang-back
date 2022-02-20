package com.nugurang.dao

import com.nugurang.entity.UserEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserDaoCustom {
    fun findFirstByTeamIdAndRoleId(team: Long, role: Long): UserEntity?
    fun findAllByBoardId(board: Long, pageable: Pageable): Page<UserEntity>
    fun findAllByFollowerId(follower: Long, pageable: Pageable): Page<UserEntity>
    fun findAllByFollowingId(following: Long, pageable: Pageable): Page<UserEntity>
    fun findAllByProjectId(project: Long): List<UserEntity>
    fun findAllByProjectId(project: Long, pageable: Pageable): Page<UserEntity>
    fun findAllByProjectIdIn(projects: List<Long>): List<UserEntity>
    fun findAllByTaskId(task: Long): List<UserEntity>
    fun findAllByTeamId(team: Long, pageable: Pageable): Page<UserEntity>
    fun findAllByTeamIdAndRoleId(team: Long, role: Long, pageable: Pageable): Page<UserEntity>
}