package com.nugurang.dao

import com.nugurang.entity.*
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class TaskDaoImpl(private val queryFactory: JPAQueryFactory) : TaskDaoCustom {

    override fun findAllByProjectId(project: Long): List<TaskEntity> {
        return queryFactory.selectFrom(QTaskEntity.taskEntity).innerJoin(QWorkEntity.workEntity)
            .on(QTaskEntity.taskEntity.work.id.eq(QWorkEntity.workEntity.id)).innerJoin(QProjectEntity.projectEntity)
            .on(QWorkEntity.workEntity.project.id.eq(QProjectEntity.projectEntity.id))
            .where(QProjectEntity.projectEntity.id.eq(project)).fetch()
    }

    override fun findAllByUserId(user: Long): List<TaskEntity> {
        return queryFactory.selectFrom(QTaskEntity.taskEntity).innerJoin(QXrefUserTaskEntity.xrefUserTaskEntity)
            .on(QTaskEntity.taskEntity.id.eq(QXrefUserTaskEntity.xrefUserTaskEntity.task.id))
            .where(QXrefUserTaskEntity.xrefUserTaskEntity.user.id.eq(user)).fetch()
    }
}