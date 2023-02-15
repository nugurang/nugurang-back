package com.nugurang.service

import com.nugurang.annotation.DaoOp
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
            TaskEntity(
                name = taskInputDto.name,
                order = taskInputDto.order
                    ?: (taskDao.findFirstByOrderByOrderDesc()?.let { it.order + 1 } ?: 0),
                difficulty = taskInputDto.difficulty ?: 1,
                work = workDao.findByIdOrNull(work) ?: throw NotFoundException(WorkEntity::class.java),
                progress = taskInputDto.progress?.let {
                    progressDao.findByIdOrNull(it) ?: throw NotFoundException(ProgressEntity::class.java)
                }
                ?: (progressDao.findByName(ProgressName.TODO.name) ?: throw NotFoundException(ProgressEntity::class.java))
            )
        )

        xrefUserTaskDao.saveAll(
            taskInputDto.users.map { userService.getUser(it) }
            .map { XrefUserTaskEntity(user = it, task = taskEntity) }
        )

        xrefTaskPositionDao.saveAll(
            taskInputDto.positions.map {
                positionDao.findByIdOrNull(it) ?: throw NotFoundException(PositionEntity::class.java)
            }
            .map { XrefTaskPositionEntity(task = taskEntity, position = it) }
        )

        return taskEntity
    }

    fun getTask(taskId: Long): TaskEntity {
        return taskDao.findByIdOrNull(taskId) ?: throw NotFoundException(TaskEntity::class.java)
    }

    @DaoOp
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

    @DaoOp
    fun deleteTask(taskId: Long): Long {
        taskDao.deleteById(taskId)
        return taskId
    }
}