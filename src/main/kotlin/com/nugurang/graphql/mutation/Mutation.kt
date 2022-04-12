package com.nugurang.graphql.mutation

import com.nugurang.constant.InvitationStatusName
import com.nugurang.constant.RoleName
import com.nugurang.constant.UserEvaluationConstant
import com.nugurang.dao.*
import com.nugurang.dto.*
import com.nugurang.entity.*
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.InvitationMapper
import com.nugurang.mapper.MatchRequestMapper
import com.nugurang.mapper.PositionMapper
import com.nugurang.service.ImageService
import com.nugurang.service.NotificationService
import com.nugurang.service.ProjectService
import com.nugurang.service.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime
import kotlin.math.max

@Service
class Mutation(
    private val imageService: ImageService,
    private val notificationService: NotificationService,
    private val userService: UserService,
    private val projectService: ProjectService,
    private val eventDao: EventDao,
    private val followingDao: FollowingDao,
    private val groupDao: GroupDao,
    private val invitationDao: InvitationDao,
    private val invitationStatusDao: InvitationStatusDao,
    private val matchRequestDao: MatchRequestDao,
    private val matchTypeDao: MatchTypeDao,
    private val positionDao: PositionDao,
    private val projectDao: ProjectDao,
    private val roleDao: RoleDao,
    private val taskDao: TaskDao,
    private val taskReviewDao: TaskReviewDao,
    private val teamDao: TeamDao,
    private val userDao: UserDao,
    private val userEvaluationDao: UserEvaluationDao,
    private val userHonorDao: UserHonorDao,
    private val userReviewDao: UserReviewDao,
    private val xrefUserProjectDao: XrefUserProjectDao,
    private val xrefUserTeamDao: XrefUserTeamDao,
    private val invitationMapper: InvitationMapper,
    private val matchRequestMapper: MatchRequestMapper,
    private val positionMapper: PositionMapper,
) : GraphQLMutationResolver {

    fun createFollowing(userId: Long): Boolean {
        val fromUser = userService.getCurrentUser()
        val toUser = userService.getUser(userId)
        if (fromUser.id === toUser.id)
            return false
        followingDao.save(
            FollowingEntity(
                fromUser = fromUser,
                toUser = toUser
            )
        )
        return true
    }

    @Transactional
    fun createInvitations(invitationInputDto: InvitationInputDto): List<InvitationDto> {
        val currentUserEntity = userService.getCurrentUser()
        return invitationInputDto.users
            .map { userId -> userService.getUser(userId) }
            .map { userEntity ->
                val invitationEntity = invitationDao.save(
                    InvitationEntity(
                        status = invitationStatusDao.findByName(InvitationStatusName.UNACCEPTED.name)
                            ?: throw NotFoundException(InvitationStatusEntity::class.java),
                        group = groupDao.findByIdOrNull(invitationInputDto.group)
                            ?: throw NotFoundException(GroupEntity::class.java),
                        fromUser = currentUserEntity,
                        toUser = userEntity
                    )
                )
                notificationService.createInvitationNotification(userEntity, invitationEntity)
                invitationMapper.toDto(invitationEntity)
            }
    }

    fun createMatchRequest(matchRequestInputDto: MatchRequestInputDto): MatchRequestDto {
        log.info("Creating match request...")
        val now = OffsetDateTime.now()
        return matchRequestMapper.toDto(
            matchRequestDao.save(
                MatchRequestEntity(
                    createdAt = now,
                    expiresAt = now
                    .plusDays((matchRequestInputDto.days ?: 1) as Long) // TODO: Fix type casting
                    .plusHours((matchRequestInputDto.hours ?: 0) as Long)
                    .plusMinutes((matchRequestInputDto.minutes ?: 0) as Long),
                    minTeamSize = matchRequestInputDto.minTeamSize,
                    maxTeamSize = matchRequestInputDto.maxTeamSize,
                    type = matchTypeDao.findByIdOrNull(matchRequestInputDto.type)
                    ?: throw NotFoundException(MatchTypeEntity::class.java),
                    event = eventDao.findByIdOrNull(matchRequestInputDto.event)
                    ?: throw NotFoundException(EventEntity::class.java),
                    user = userService.getCurrentUser()
                )
            )
        )
    }

    fun createPosition(positionInputDto: PositionInputDto): PositionDto {
        return positionMapper.toDto(
            positionDao.save(
                PositionEntity(
                    name = positionInputDto.name,
                    description = positionInputDto.description,
                    image = positionInputDto.image?.let { imageService.getImage(it) }
                )
            )
        )
    }

    fun createTag(tagInputDto: TagInputDto): TagDto {
        // TODO: implement this method
        return object {} as TagDto
    }

    @Transactional
    fun updateInvitationAccepted(invitationId: Long): Boolean {
        val invitationEntity = invitationDao.findByIdOrNull(invitationId)
            ?: throw NotFoundException(InvitationEntity::class.java)
        invitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.ACCEPTED.name)
            ?: throw NotFoundException(InvitationStatusEntity::class.java)
        invitationDao.save(invitationEntity)
        when (invitationEntity.group) {
            is ProjectEntity -> {
                xrefUserProjectDao.save(
                    XrefUserProjectEntity(
                        user = invitationEntity.toUser,
                        project = invitationEntity.group as ProjectEntity,
                        role = roleDao.findByName(RoleName.MEMBER.name) ?: throw NotFoundException(RoleEntity::class.java)
                    )
                )
            }
            is TeamEntity -> {
                xrefUserTeamDao.save (
                    XrefUserTeamEntity(
                        user = invitationEntity.toUser,
                        team = invitationEntity.group as TeamEntity,
                        role = roleDao.findByName(RoleName.MEMBER.name) ?: throw NotFoundException(RoleEntity::class.java)
                    )
                )
            }
            else -> {
                throw RuntimeException("Unknown Group Type")
            }
        }
        return true
    }

    fun updateInvitationDenied(invitationId: Long): Boolean {
        val invitationEntity = invitationDao.findByIdOrNull(invitationId) ?: throw NotFoundException(InvitationEntity::class.java)
        invitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.DENIED.name)
            ?: throw NotFoundException(InvitationStatusEntity::class.java)
        invitationDao.save(invitationEntity)
        return true
    }


    fun updateProjectFinish(projectId: Long): Boolean {
        var projectEntity = projectService.getProject(projectId)

        if (projectEntity.finished)
            return false

        val now = OffsetDateTime.now()
        val userEvaluationEntity = userEvaluationDao.save(
            UserEvaluationEntity(
                createdAt = now,
                expiresAt = now.plusDays(UserEvaluationConstant.DAYS.toLong())
            )
        )
        projectEntity.finished = true
        projectEntity.userEvaluation = userEvaluationEntity
        projectEntity = projectDao.save(projectEntity)

        for (taskEntity in taskDao.findAllByProjectId(projectId)) {
            val taskReviewEntities = taskReviewDao.findAllByTaskId(taskEntity.id!!)
            // log.info("task review entities size: " + taskReviewEntities.size());
            var honorPerPosition = taskReviewEntities
                .sumOf { taskEntity.difficulty * it.honor } / max(1, taskReviewEntities.size)

            val userEntities = userDao.findAllByTaskId(taskEntity.id!!)
            // log.info("user entities size: " + userEntities.size());
            honorPerPosition /= max(1, userEntities.size)

            for (userEntity in userEntities) {
                val positionEntities = positionDao.findAllByTaskId(taskEntity.id!!)
                // log.info("position entities size: " + positionEntities.size());
                honorPerPosition /= max(1, positionEntities.size)
                // log.info("honor per position: " + honorPerPosition);
                for (positionEntity in positionEntities) {
                    val userHonorEntity = userHonorDao.findByUserIdAndPositionId(userEntity.id!!, positionEntity.id!!)
                    ?: UserHonorEntity(user = userEntity, honor = 0, position = positionEntity)
                    userHonorEntity.honor = userHonorEntity.honor + honorPerPosition
                    userHonorDao.save(userHonorEntity)
                }
            }
        }
        return true
    }

    @Transactional
    fun updateTaskReview(taskReviewInputDto: TaskReviewInputDto): Boolean {
        val taskEntity = taskDao.findById(taskReviewInputDto.task).get()
        val userEntity = userService.getCurrentUser()
        taskReviewDao.deleteByTaskIdAndUserId(taskEntity.id!!, userEntity.id!!)
        taskReviewDao.save(
            TaskReviewEntity(
                honor = taskReviewInputDto.honor,
                task = taskEntity,
                user = userEntity
            )
        )
        return true
    }

    @Transactional
    fun updateUserReviews(userReviewInputDtos: List<UserReviewInputDto>, userEvaluation: Long): Boolean {
        val userEvaluationEntity = userEvaluationDao.findById(userEvaluation).get()
        val currentUserEntity = userService.getCurrentUser()
        userReviewInputDtos
        .map { (toUser) -> toUser }
        .forEach { toUserId ->
            userReviewDao.deleteByUserEvaluationIdAndFromUserIdAndToUserId(
                userEvaluationEntity.id!!,
                currentUserEntity.id!!,
                toUserId
            )
        }

        val userReviewEntities = userReviewDao.saveAll(
            userReviewInputDtos.flatMap { (toUser, honors) ->
                honors.map { (position, honor) ->
                    UserReviewEntity(
                        honor = honor,
                        fromUser = currentUserEntity,
                        toUser = userService.getUser(toUser),
                        position = positionDao.findByIdOrNull(position)
                            ?: throw NotFoundException(PositionEntity::class.java),
                        userEvaluation = userEvaluationEntity
                    )
                }
            }
        )

        return true
    }

    fun deleteFollowing(user: Long): Long {
        return user
    }

    fun deleteRole(id: Long): Long {
        return id
    }

    fun deleteTag(id: Long): Long {
        return id
    }

    fun deleteVoteType(id: Long): Long {
        return id
    }

    companion object {
        private val log = LoggerFactory.getLogger(Mutation::class.java)
    }
}
