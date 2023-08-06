package com.nugurang.service

import com.nugurang.annotation.DaoOp
import com.nugurang.dao.*
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.UserHonorEntity
import com.nugurang.exception.NotFoundException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import java.time.OffsetDateTime

@Component
class UserEvaluationService(
    private val projectDao: ProjectDao,
    private val userDao: UserDao,
    private val userEvaluationDao: UserEvaluationDao,
    private val userHonorDao: UserHonorDao,
    private val userReviewDao: UserReviewDao
) {

    private val logger = KotlinLogging.logger {}

    @DaoOp
    fun evaluateUsers() {
        logger.info { "user evaluation task" }
        val userEvaluationEntities = userEvaluationDao.findAllByExpiresAtLessThanEqual(OffsetDateTime.now())
        // should fix
        val userReviewEntities = userReviewDao.findAllByToUserIdIn(
            userDao.findAllByProjectIdIn(
                userEvaluationEntities
                .map {
                    projectDao.findByUserEvaluationId(it.id!!)
                    ?: throw NotFoundException(ProjectEntity::class.java)
                }
                .map { it.id!! }
            )
            .map { it.id!! }
        )

        userHonorDao.saveAll(userReviewEntities.map { userReviewEntity ->
            val userHonorEntity = userHonorDao.findByUserIdAndPositionId(
                userReviewEntity.toUser.id!!, userReviewEntity.position.id!!
            )
            ?: UserHonorEntity(
                honor = 0,
                user = userReviewEntity.toUser,
                position = userReviewEntity.position
            )
            userHonorEntity.honor = userHonorEntity.honor + userReviewEntity.honor

            userHonorEntity
        })

        userReviewDao.deleteAllByIdIn(userReviewEntities.map { it.id!! })

        userEvaluationDao.deleteAllByIdIn(userEvaluationEntities.map { it.id!! })
    }
}
