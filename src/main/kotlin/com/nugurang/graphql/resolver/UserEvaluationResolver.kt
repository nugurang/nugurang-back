package com.nugurang.graphql.resolver

import com.nugurang.dao.ProjectDao
import com.nugurang.dao.UserReviewDao
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.UserEvaluationDto
import com.nugurang.dto.UserReviewDto
import com.nugurang.entity.ProjectEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.ProjectMapper
import com.nugurang.mapper.UserReviewMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class UserEvaluationResolver(
    private val projectDao: ProjectDao,
    private val userReviewDao: UserReviewDao,
    private val projectMapper: ProjectMapper,
    private val userReviewMapper: UserReviewMapper
) : GraphQLResolver<UserEvaluationDto> {
    fun project(userEvaluationDto: UserEvaluationDto): ProjectDto {
        return projectDao
        .findByUserEvaluationId(userEvaluationDto.id)
        ?.let(projectMapper::toDto)
        ?: throw NotFoundException(ProjectEntity::class.java)
    }

    fun reviews(userEvaluationDto: UserEvaluationDto): List<UserReviewDto> {
        return userReviewDao
        .findAllByUserEvaluationId(userEvaluationDto.id)
        .map(userReviewMapper::toDto)
    }
}