package com.nugurang.service

import com.nugurang.dao.*
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.UserEntity
import com.nugurang.entity.UserHonorEntity
import com.nugurang.exception.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Component
class UserEvaluationService(
    private val projectDao: ProjectDao,
    private val userDao: UserDao,
    private val userEvaluationDao: UserEvaluationDao,
    private val userHonorDao: UserHonorDao,
    private val userReviewDao: UserReviewDao
) {

    @Transactional
    fun evaluateUsers() {
        log.info("user evaluation task")
        val userEvaluationEntities = userEvaluationDao.findAllByExpiresAtLessThanEqual(OffsetDateTime.now())
        // should fix
        val userReviewEntities = userReviewDao.findAllByToUserIdIn(
            userDao.findAllByProjectIdIn(
                userEvaluationEntities
                .map { userEvaluationEntity ->
                    projectDao.findByUserEvaluationId(userEvaluationEntity.id)
                    ?: throw NotFoundException(ProjectEntity::class.java)
                }
                .map { projectEntity: ProjectEntity -> projectEntity.id }
            )
            .map { userEntity: UserEntity -> userEntity.id }
        )

        userHonorDao.saveAll(userReviewEntities.map { userReviewEntity ->
            val userHonorEntity = userHonorDao.findByUserIdAndPositionId(
                userReviewEntity.toUser.id, userReviewEntity.position.id
            )
            ?: UserHonorEntity
           .builder()
           .honor(0)
           .user(userReviewEntity.toUser)
           .position(userReviewEntity.position)
           .build()

            userHonorEntity.honor = userHonorEntity.honor + userReviewEntity.honor

            userHonorEntity
        })

        userReviewDao.deleteAllByIdIn(userReviewEntities.map { it.id })

        userEvaluationDao.deleteAllByIdIn(userEvaluationEntities.map { it.id })

    }

    companion object {
        private val log = LoggerFactory.getLogger(UserEvaluationService::class.java)
    }
}