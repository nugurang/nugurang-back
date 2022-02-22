package com.nugurang.dao

import com.nugurang.entity.*
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class UserDaoImpl(private val queryFactory: JPAQueryFactory) : UserDaoCustom {

    override fun findFirstByTeamIdAndRoleId(team: Long, role: Long): UserEntity {
        return queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserTeamEntity.xrefUserTeamEntity)
                .on(QUserEntity.userEntity.id.eq(QXrefUserTeamEntity.xrefUserTeamEntity.user.id))
                .where(QXrefUserTeamEntity.xrefUserTeamEntity.team.id.eq(team))
                .where(QXrefUserTeamEntity.xrefUserTeamEntity.role.id.eq(role)).fetchFirst()
    }

    override fun findAllByBoardId(board: Long, pageable: Pageable): Page<UserEntity> {
        val results =
            queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserBoardEntity.xrefUserBoardEntity)
                .on(QUserEntity.userEntity.id.eq(QXrefUserBoardEntity.xrefUserBoardEntity.user.id))
                .where(QXrefUserBoardEntity.xrefUserBoardEntity.board.id.eq(board)).offset(pageable.offset)
                .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }

    override fun findAllByFollowerId(follower: Long, pageable: Pageable): Page<UserEntity> {
        val results = queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QFollowingEntity.followingEntity)
            .on(QUserEntity.userEntity.id.eq(QFollowingEntity.followingEntity.toUser.id))
            .where(QFollowingEntity.followingEntity.fromUser.id.eq(follower)).offset(pageable.offset)
            .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }

    override fun findAllByFollowingId(following: Long, pageable: Pageable): Page<UserEntity> {
        val results = queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QFollowingEntity.followingEntity)
            .on(QUserEntity.userEntity.id.eq(QFollowingEntity.followingEntity.fromUser.id))
            .where(QFollowingEntity.followingEntity.toUser.id.eq(following)).offset(pageable.offset)
            .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }

    override fun findAllByProjectId(project: Long): List<UserEntity> {
        return queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserProjectEntity.xrefUserProjectEntity)
            .on(QUserEntity.userEntity.id.eq(QXrefUserProjectEntity.xrefUserProjectEntity.user.id))
            .where(QXrefUserProjectEntity.xrefUserProjectEntity.project.id.eq(project)).fetch()
    }

    override fun findAllByProjectId(project: Long, pageable: Pageable): Page<UserEntity> {
        val results =
            queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserProjectEntity.xrefUserProjectEntity)
                .on(QUserEntity.userEntity.id.eq(QXrefUserProjectEntity.xrefUserProjectEntity.user.id))
                .where(QXrefUserProjectEntity.xrefUserProjectEntity.project.id.eq(project)).offset(pageable.offset)
                .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }

    override fun findAllByProjectIdIn(projects: List<Long>): List<UserEntity> {
        return queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserProjectEntity.xrefUserProjectEntity)
            .on(QUserEntity.userEntity.id.eq(QXrefUserProjectEntity.xrefUserProjectEntity.user.id))
            .where(QXrefUserProjectEntity.xrefUserProjectEntity.project.id.`in`(projects)).fetch()
    }

    override fun findAllByTaskId(task: Long): List<UserEntity> {
        return queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserTaskEntity.xrefUserTaskEntity)
            .on(QUserEntity.userEntity.id.eq(QXrefUserTaskEntity.xrefUserTaskEntity.user.id))
            .where(QXrefUserTaskEntity.xrefUserTaskEntity.task.id.eq(task)).fetch()
    }

    override fun findAllByTeamId(team: Long, pageable: Pageable): Page<UserEntity> {
        val results = queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserTeamEntity.xrefUserTeamEntity)
            .on(QUserEntity.userEntity.id.eq(QXrefUserTeamEntity.xrefUserTeamEntity.user.id))
            .where(QXrefUserTeamEntity.xrefUserTeamEntity.team.id.eq(team)).offset(pageable.offset)
            .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }

    override fun findAllByTeamIdAndRoleId(team: Long, role: Long, pageable: Pageable): Page<UserEntity> {
        val results = queryFactory.selectFrom(QUserEntity.userEntity).innerJoin(QXrefUserTeamEntity.xrefUserTeamEntity)
            .on(QUserEntity.userEntity.id.eq(QXrefUserTeamEntity.xrefUserTeamEntity.user.id))
            .where(QXrefUserTeamEntity.xrefUserTeamEntity.team.id.eq(team))
            .where(QXrefUserTeamEntity.xrefUserTeamEntity.role.id.eq(role)).offset(pageable.offset)
            .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }
}