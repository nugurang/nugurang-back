package com.nugurang.graphql.resolver

import com.nugurang.dao.*
import com.nugurang.dto.*
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserResolver(
    private val articleDao: ArticleDao,
    private val boardDao: BoardDao,
    private val imageDao: ImageDao,
    private val projectDao: ProjectDao,
    private val teamDao: TeamDao,
    private val threadDao: ThreadDao,
    private val userDao: UserDao,
    private val userHonorDao: UserHonorDao,
    private val notificationDao: NotificationDao
) : GraphQLResolver<UserDto> {

    fun totalHonor(userDto: UserDto): Int {
        return userHonorDao.findAllByUserId(userDto.id).sumOf { it.honor }
    }

    fun honors(userDto: UserDto): List<UserHonorDto> {
        return userHonorDao.findAllByUserId(userDto.id).map { it.toDto() }
    }

    fun image(userDto: UserDto): ImageDto? {
        return userDao.findByIdOrNull(userDto.id)?.image?.toDto()
    }

    fun blog(userDto: UserDto): BoardDto {
        return userDao.findById(userDto.id).get().blog.toDto()
    }

    fun getArticles(userDto: UserDto, page: Int, pageSize: Int): List<ArticleDto> {
        return articleDao
            .findAllByUserId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun getFollowings(userDto: UserDto, page: Int, pageSize: Int): List<UserDto> {
        return userDao
            .findAllByFollowerId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun getFollowers(userDto: UserDto, page: Int, pageSize: Int): List<UserDto> {
        return userDao
            .findAllByFollowingId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun getNotifications(userDto: UserDto, page: Int, pageSize: Int): List<NotificationDto> {
        return notificationDao
            .findAllByUserId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun getProjects(userDto: UserDto, page: Int, pageSize: Int): List<ProjectDto> {
        return projectDao
            .findAllByUserId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun getTeams(userDto: UserDto, page: Int, pageSize: Int): List<TeamDto> {
        return teamDao
            .findAllByUserId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun getThreads(userDto: UserDto, page: Int, pageSize: Int): List<ThreadDto> {
        return threadDao
            .findAllByUserId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.toDto() }
            .collect(Collectors.toList())
    }

    fun getUserEvaluations(userDto: UserDto, page: Int, pageSize: Int): List<UserEvaluationDto> {
        return projectDao
            .findAllByUserId(userDto.id, PageRequest.of(page, pageSize))
            .stream()
            .map { it.userEvaluation }
            .map { it.toDto() }
            .collect(Collectors.toList())
    }
}