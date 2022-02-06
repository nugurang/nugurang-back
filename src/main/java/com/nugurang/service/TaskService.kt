package com.nugurang.service

import com.nugurang.constant.ProgressName
import com.nugurang.dao.*
import com.nugurang.dto.TaskInputDto
import com.nugurang.entity.*
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskService(
    private val userService: UserService,
    private val positionDao: PositionDao,
    private val progressDao: ProgressDao,
    private val taskDao: TaskDao,
    private val workDao: WorkDao,
    private val xrefTaskPositionDao: XrefTaskPositionDao,
    private val xrefUserTaskDao: XrefUserTaskDao,
) {
    @Transactional
    fun createTask(taskInputDto: TaskInputDto, work: Long): TaskEntity {
        val taskEntity = taskDao.save(
            TaskEntity
            .builder()
            .name(taskInputDto.name)
            .order(taskInputDto.order
                ?: (taskDao.findFirstByOrderByOrderDesc()?.let { prevTaskEntity -> prevTaskEntity.order + 1 } ?: 0)
            )
            .difficulty(taskInputDto.difficulty ?: 1)
            .work(workDao.findByIdOrNull(work) ?: throw NotFoundException(WorkEntity::class.java))
            .progress(
                taskInputDto.progress?.let { progressId ->
                    progressDao.findByIdOrNull(progressId) ?: throw NotFoundException(ProgressEntity::class.java)
                }
                ?: (progressDao.findByName(ProgressName.TODO.name) ?: throw NotFoundException(ProgressEntity::class.java))
            ).build()
        )

        xrefUserTaskDao.saveAll(
            taskInputDto.users.map { userId -> userService.getUser(userId) }
            .map { userEntity: UserEntity? -> XrefUserTaskEntity.builder().user(userEntity).task(taskEntity).build() }
        )

        xrefTaskPositionDao.saveAll(
            taskInputDto.positions.map { positionId: Long -> positionDao.findById(positionId).get() }
            .map { positionEntity: PositionEntity? ->
                XrefTaskPositionEntity.builder().task(taskEntity).position(positionEntity).build()
            }
        )

        return taskEntity
    }

    fun getTask(taskId: Long): TaskEntity {
        return taskDao.findByIdOrNull(taskId) ?: throw NotFoundException(TaskEntity::class.java)
    }

    fun updateTask(taskInputDto: TaskInputDto, taskId: Long): TaskEntity {
        val taskEntity = taskDao.findById(taskId).get()
        taskEntity.name = taskInputDto.name
        taskInputDto.order?.let { taskEntity.order = it }
        taskInputDto.difficulty?.let { taskEntity.difficulty = it }
        taskInputDto.progress?.let {
            taskEntity.progress = progressDao.findByIdOrNull(it) ?: throw NotFoundException(ProgressEntity::class.java)
        }

        return taskDao.save(taskEntity)
    }

    fun deleteTask(taskId: Long): Long {
        taskDao.deleteById(taskId)
        return taskId
    }
}