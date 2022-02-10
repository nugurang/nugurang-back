package com.nugurang.graphql.resolver

import com.nugurang.dao.*
import com.nugurang.dto.*
import com.nugurang.entity.PositionEntity
import com.nugurang.entity.UserEntity
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TaskResolver(
    private val workerDao: WorkDao,
    private val progressDao: ProgressDao,
    private val positionDao: PositionDao,
    private val taskDao: TaskDao,
    private val userDao: UserDao
) : GraphQLResolver<TaskDto> {

    fun work(taskDto: TaskDto): WorkDto {
        return taskDao.findById(taskDto.id).get().work.toDto()
    }

    fun progress(taskDto: TaskDto): ProgressDto {
        return taskDao.findById(taskDto.id).get().progress.toDto()
    }

    fun positions(taskDto: TaskDto): List<PositionDto> {
        return positionDao.findAllByTaskId(taskDto.id).stream().map { entity: PositionEntity -> entity.toDto() }
            .collect(Collectors.toList())
    }

    fun users(taskDto: TaskDto): List<UserDto> {
        return userDao.findAllByTaskId(taskDto.id).stream().map { entity: UserEntity -> entity.toDto() }
            .collect(Collectors.toList())
    }
}