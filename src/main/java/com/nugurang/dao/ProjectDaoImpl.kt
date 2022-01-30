package com.nugurang.dao

import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.QProjectEntity
import com.nugurang.entity.QXrefUserProjectEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class ProjectDaoImpl(private val queryFactory: JPAQueryFactory) : ProjectDaoCustom {
    override fun findAllByUserId(user: Long, pageable: Pageable): Page<ProjectEntity> {
        val results = queryFactory.selectFrom(QProjectEntity.projectEntity)
            .innerJoin(QXrefUserProjectEntity.xrefUserProjectEntity)
            .on(QXrefUserProjectEntity.xrefUserProjectEntity.project.id.eq(QProjectEntity.projectEntity.id))
            .where(QXrefUserProjectEntity.xrefUserProjectEntity.user.id.eq(user)).offset(pageable.offset)
            .limit(pageable.pageSize.toLong()).fetchResults()
        return PageImpl(results.results, pageable, results.total)
    }
}