package com.nugurang.graphql.resolver

import com.nugurang.dao.*
import com.nugurang.dto.*
import com.nugurang.mapper.PositionMapper
import com.nugurang.mapper.ProgressMapper
import com.nugurang.mapper.UserMapper
import com.nugurang.mapper.WorkMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class TaskResolver(
    private val workerDao: WorkDao,
    private val progressDao: ProgressDao,
    private val positionDao: PositionDao,
    private val taskDao: TaskDao,
    private val userDao: UserDao,
    private val positionMapper: PositionMapper,
    private val progressMapper: ProgressMapper,
    private val userMapper: UserMapper,
    private val workMapper: WorkMapper,
) : GraphQLResolver<TaskDto> {

    fun work(taskDto: TaskDto): WorkDto {
        return workMapper.toDto(taskDao.findById(taskDto.id).get().work)
    }

    fun progress(taskDto: TaskDto): ProgressDto {
        return progressMapper.toDto(taskDao.findById(taskDto.id).get().progress)
    }

    fun positions(taskDto: TaskDto): List<PositionDto> {
        return positionDao.findAllByTaskId(taskDto.id).map(positionMapper::toDto)
    }

    fun users(taskDto: TaskDto): List<UserDto> {
        return userDao.findAllByTaskId(taskDto.id).map(userMapper::toDto)
    }
}