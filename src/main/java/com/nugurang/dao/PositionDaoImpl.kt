package com.nugurang.dao

import com.nugurang.entity.PositionEntity
import com.nugurang.entity.QPositionEntity
import com.nugurang.entity.QUserHonorEntity
import com.nugurang.entity.QXrefTaskPositionEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class PositionDaoImpl(private val queryFactory: JPAQueryFactory) : PositionDaoCustom {
    override fun findAllByTaskId(task: Long): List<PositionEntity> {
        return queryFactory.selectFrom(QPositionEntity.positionEntity)
            .innerJoin(QXrefTaskPositionEntity.xrefTaskPositionEntity)
            .on(QPositionEntity.positionEntity.id.eq(QXrefTaskPositionEntity.xrefTaskPositionEntity.position.id))
            .where(QXrefTaskPositionEntity.xrefTaskPositionEntity.task.id.eq(task)).fetch()
    }

    override fun findAllByUserIdAndTaskId(user: Long, task: Long): List<PositionEntity> {
        return queryFactory.selectFrom(QPositionEntity.positionEntity).innerJoin(QUserHonorEntity.userHonorEntity)
            .on(QPositionEntity.positionEntity.id.eq(QUserHonorEntity.userHonorEntity.position.id))
            .innerJoin(QXrefTaskPositionEntity.xrefTaskPositionEntity)
            .on(QPositionEntity.positionEntity.id.eq(QXrefTaskPositionEntity.xrefTaskPositionEntity.position.id))
            .where(QUserHonorEntity.userHonorEntity.user.id.eq(user))
            .where(QXrefTaskPositionEntity.xrefTaskPositionEntity.task.id.eq(task)).fetch()
    }
}