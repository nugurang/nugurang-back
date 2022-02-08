package com.nugurang.graphql.mutation

import com.nugurang.constant.InvitationStatusName
import com.nugurang.constant.RoleName
import com.nugurang.constant.UserEvaluationConstant
import com.nugurang.dao.*
import com.nugurang.dto.*
import com.nugurang.entity.*
import com.nugurang.exception.NotFoundException
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
import java.util.function.ToIntFunction
import java.util.stream.Collectors

@Service
class Mutation(
    private val imageService: ImageService,
    private val notificationService: NotificationService,
    private val userService: UserService,
    private val projectService: ProjectService,
    private val eventDao: EventDao,
    private val followingDao: FollowingDao,
    private val imageDao: ImageDao,
    private val invitationStatusDao: InvitationStatusDao,
    private val matchRequestDao: MatchRequestDao,
    private val matchTypeDao: MatchTypeDao,
    private val positionDao: PositionDao,
    private val projectDao: ProjectDao,
    private val projectInvitationDao: ProjectInvitationDao,
    private val roleDao: RoleDao,
    private val taskDao: TaskDao,
    private val taskReviewDao: TaskReviewDao,
    private val teamDao: TeamDao,
    private val teamInvitationDao: TeamInvitationDao,
    private val userDao: UserDao,
    private val userEvaluationDao: UserEvaluationDao,
    private val userHonorDao: UserHonorDao,
    private val userReviewDao: UserReviewDao,
    private val xrefUserProjectDao: XrefUserProjectDao,
    private val xrefUserTeamDao: XrefUserTeamDao
) : GraphQLMutationResolver {

    fun createFollowing(userId: Long): Boolean {
        val fromUser = userService.getCurrentUser()
        val toUser = userService.getUser(userId)
        if (fromUser.id === toUser.id)
            return false
        followingDao.save(FollowingEntity.builder().fromUser(fromUser).toUser(toUser).build())
        return true
    }

    fun createMatchRequest(matchRequestInputDto: MatchRequestInputDto): MatchRequestDto {
        log.info("Creating match request...")
        val now = OffsetDateTime.now()
        return matchRequestDao.save(
            MatchRequestEntity
            .builder()
            .createdAt(now)
            .expiresAt(
                now
                .plusDays((matchRequestInputDto.days ?: 1) as Long) // TODO: Fix type casting
                .plusHours((matchRequestInputDto.hours ?: 0) as Long)
                .plusMinutes((matchRequestInputDto.minutes ?: 0) as Long)
            )
            .minTeamSize(matchRequestInputDto.minTeamSize)
            .maxTeamSize(matchRequestInputDto.maxTeamSize)
            .type(
                matchTypeDao.findByIdOrNull(matchRequestInputDto.type)
                ?: throw NotFoundException(MatchTypeEntity::class.java)
            )
            .event(
                eventDao.findByIdOrNull(matchRequestInputDto.event)
                ?: throw NotFoundException(EventEntity::class.java))
            .user(userService.getCurrentUser())
            .build()
        ).toDto()
    }

    fun createPosition(positionInputDto: PositionInputDto): PositionDto {
        return positionDao.save(
            PositionEntity
            .builder()
            .name(positionInputDto.name)
            .description(positionInputDto.description)
            .image(positionInputDto.image?.let { imageId -> imageService.getImage(imageId) })
            .build()
        )
        .toDto()
    }

    fun createProjectInvitations(projectInvitationInputDto: ProjectInvitationInputDto): List<ProjectInvitationDto> {
        val currentUserEntity = userService.getCurrentUser()
        return projectInvitationInputDto.users
            .map { userId -> userService.getUser(userId) }
            .map { userEntity ->
                val projectEntity = projectService.getProject(projectInvitationInputDto.project)
                val projectInvitationEntity = projectInvitationDao.save(
                    ProjectInvitationEntity
                    .builder()
                    .status(
                        invitationStatusDao.findByName(InvitationStatusName.UNACCEPTED.name)
                        ?: throw NotFoundException(InvitationStatusEntity::class.java)
                    )
                    .project(projectEntity)
                    .fromUser(currentUserEntity)
                    .toUser(userEntity)
                    .build()
                )
                notificationService.createProjectInvitationNotification(userEntity!!, projectInvitationEntity)
                projectInvitationEntity.toDto()
            }
    }

    fun createTag(tagInputDto: TagInputDto): TagDto {
        // TODO: implement this method
        return object {} as TagDto
    }

    @Transactional
    fun createTeamInvitations(teamInvitationInputDto: TeamInvitationInputDto): List<TeamInvitationDto> {
        val currentUserEntity = userService.getCurrentUser()
        return teamInvitationInputDto.users
        .map { userId -> userService.getUser(userId) }
        .map { userEntity ->
            val teamEntity = teamDao.findByIdOrNull(teamInvitationInputDto.team)
            ?: throw NotFoundException(TeamEntity::class.java)

            val teamInvitationEntity = teamInvitationDao.save(
                TeamInvitationEntity
                .builder()
                .status(
                    invitationStatusDao.findByName(InvitationStatusName.UNACCEPTED.name)
                )
                .team(teamEntity)
                .fromUser(currentUserEntity)
                .toUser(userEntity)
                .build()
            )

            notificationService.createTeamInvitationNotification(userEntity, teamInvitationEntity)
            teamInvitationEntity.toDto()
        }
    }

    @Transactional
    fun updateProjectInvitationAccepted(projectInvitationId: Long): Boolean {
        val projectInvitationEntity = projectInvitationDao.findByIdOrNull(projectInvitationId)
        ?: throw NotFoundException(ProjectInvitationEntity::class.java)
        projectInvitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.ACCEPTED.name)
        ?: throw NotFoundException(InvitationStatusEntity::class.java)
        projectInvitationDao.save(projectInvitationEntity)
        xrefUserProjectDao.save(
            XrefUserProjectEntity
            .builder()
            .user(projectInvitationEntity.toUser)
            .project(projectInvitationEntity.project)
            .role(roleDao.findByName(RoleName.MEMBER.name))
            .build()
        )
        return true
    }

    fun updateProjectInvitationDenied(projectInvitation: Long): Boolean {
        val projectInvitationEntity = projectInvitationDao.findById(projectInvitation).get()
        projectInvitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.DENIED.name)
        projectInvitationDao.save(projectInvitationEntity)
        return true
    }

    fun updateProjectFinish(projectId: Long): Boolean {
        var projectEntity = projectService.getProject(projectId)
        if (projectEntity.finished)
            return false
        val now = OffsetDateTime.now()
        val userEvaluationEntity = userEvaluationDao.save(
            UserEvaluationEntity
            .builder()
            .createdAt(now)
            .expiresAt(now.plusDays(UserEvaluationConstant.DAYS.toLong()))
            .build()
        )
        projectEntity.finished = true
        projectEntity.userEvaluation = userEvaluationEntity
        projectEntity = projectDao.save(projectEntity)
        for (taskEntity in taskDao.findAllByProjectId(projectId)) {
            val taskReviewEntities = taskReviewDao.findAllByTaskId(taskEntity.id)
            // log.info("task review entities size: " + taskReviewEntities.size());
            var honorPerPosition = taskReviewEntities.stream()
                .map { taskReviewEntity: TaskReviewEntity -> taskEntity.difficulty * taskReviewEntity.honor }
                .collect(
                    Collectors.summingInt(
                        ToIntFunction { obj: Int -> obj })
                )
            if (taskReviewEntities.size > 0) honorPerPosition /= taskReviewEntities.size
            val userEntities = userDao.findAllByTaskId(taskEntity.id)
            // log.info("user entities size: " + userEntities.size());
            if (userEntities.size > 0) honorPerPosition /= userEntities.size
            for (userEntity in userEntities) {
                val positionEntities = positionDao.findAllByTaskId(taskEntity.id)
                // log.info("position entities size: " + positionEntities.size());
                if (positionEntities.size > 0) honorPerPosition /= positionEntities.size
                // log.info("honor per position: " + honorPerPosition);
                for (positionEntity in positionEntities) {
                    val userHonorEntity = userHonorDao.findByUserIdAndPositionId(userEntity.id, positionEntity.id)
                    ?: UserHonorEntity.builder().user(userEntity).honor(0).position(positionEntity).build()
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
        taskReviewDao.deleteByTaskIdAndUserId(taskEntity.id, userEntity.id)
        taskReviewDao.save(
            TaskReviewEntity.builder().honor(taskReviewInputDto.honor).task(taskEntity).user(userEntity).build()
        )
        return true
    }

    fun updateTeamInvitationAccepted(teamInvitation: Long): Boolean {
        val teamInvitationEntity = teamInvitationDao.findById(teamInvitation).get()
        teamInvitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.ACCEPTED.name)
        teamInvitationDao.save(teamInvitationEntity)
        xrefUserTeamDao.save(
            XrefUserTeamEntity
            .builder()
            .user(teamInvitationEntity.toUser)
            .team(teamInvitationEntity.team)
            .role(roleDao.findByName(RoleName.MEMBER.name) ?: throw NotFoundException(RoleEntity::class.java))
            .build()
        )
        return true
    }

    fun updateTeamInvitationDenied(teamInvitation: Long): Boolean {
        val teamInvitationEntity = teamInvitationDao.findById(teamInvitation).get()
        teamInvitationEntity.status = invitationStatusDao.findByName(InvitationStatusName.DENIED.name)
        teamInvitationDao.save(teamInvitationEntity)
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
                userEvaluationEntity.id,
                currentUserEntity.id,
                toUserId
            )
        }
        val userReviewEntities = userReviewDao.saveAll(
            userReviewInputDtos.flatMap { (toUser, honors) ->
                honors.map { (position, honor) ->
                    UserReviewEntity
                    .builder()
                    .honor(honor)
                    .fromUser(currentUserEntity)
                    .toUser(userService.getUser(toUser))
                    .position(
                        positionDao.findByIdOrNull(position)
                        ?: throw NotFoundException(PositionEntity::class.java)
                    )
                    .userEvaluation(userEvaluationEntity)
                    .build()
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