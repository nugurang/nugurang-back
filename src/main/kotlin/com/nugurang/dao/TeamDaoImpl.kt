package com.nugurang.dao

import com.nugurang.entity.QTeamEntity
import com.nugurang.entity.QXrefUserTeamEntity
import com.nugurang.entity.TeamEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class TeamDaoImpl(private val queryFactory: JPAQueryFactory) : TeamDaoCustom {
    override fun findAllByUserId(user: Long, pageable: Pageable): Page<TeamEntity> {
        val results = queryFactory.selectFrom(QTeamEntity.teamEntity).innerJoin(QXrefUserTeamEntity.xrefUserTeamEntity)
            .on(QTeamEntity.teamEntity.id.eq(QXrefUserTeamEntity.xrefUserTeamEntity.team.id))
            .where(QXrefUserTeamEntity.xrefUserTeamEntity.user.id.eq(user)).offset(pageable.offset)
            .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }
}