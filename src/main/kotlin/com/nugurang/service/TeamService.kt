package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.constant.RoleName
import com.nugurang.dao.RoleDao
import com.nugurang.dao.TeamDao
import com.nugurang.dao.XrefUserTeamDao
import com.nugurang.dto.TeamInputDto
import com.nugurang.entity.RoleEntity
import com.nugurang.entity.TeamEntity
import com.nugurang.entity.XrefUserTeamEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val userService: UserService,
    private val roleDao: RoleDao,
    private val teamDao: TeamDao,
    private val xrefUserTeamDao: XrefUserTeamDao
) {
    @DaoOp
    fun createTeam(teamInputDto: TeamInputDto): TeamEntity {
        val teamEntity = teamDao.save(TeamEntity(name = teamInputDto.name))
        xrefUserTeamDao.save(
            XrefUserTeamEntity(
                user = userService.getCurrentUser(),
                team = teamEntity,
                role = roleDao.findByName(RoleName.OWNER.name) ?: throw NotFoundException(RoleEntity::class.java),
            )
        )
        return teamEntity
    }

    fun getTeam(teamId: Long): TeamEntity {
        return teamDao.findByIdOrNull(teamId) ?: throw NotFoundException(TeamEntity::class.java)
    }

    fun getTeam(teamName: String): TeamEntity {
        return teamDao.findByName(teamName) ?: throw NotFoundException(TeamEntity::class.java)
    }

    fun getTeams(teamName: String, pageable: Pageable): List<TeamEntity> {
        return teamDao.findAllByNameContainingIgnoreCase(teamName, pageable).content
    }

    @DaoOp
    fun updateTeam(teamInputDto: TeamInputDto, id: Long): TeamEntity {
        val teamEntity = teamDao.findByIdOrNull(id) ?: throw NotFoundException(TeamEntity::class.java)
        teamEntity.name = teamInputDto.name
        return teamDao.save(teamEntity)
    }

    @DaoOp
    fun deleteTeam(teamId: Long) {
        teamDao.deleteById(teamId)
    }
}