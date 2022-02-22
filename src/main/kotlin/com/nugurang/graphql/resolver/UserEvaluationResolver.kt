package com.nugurang.graphql.resolver

import com.nugurang.dao.ProjectDao
import com.nugurang.dao.UserReviewDao
import com.nugurang.dto.ProjectDto
import com.nugurang.dto.UserEvaluationDto
import com.nugurang.dto.UserReviewDto
import com.nugurang.entity.UserReviewEntity
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserEvaluationResolver(private val projectDao: ProjectDao, private val userReviewDao: UserReviewDao) :
    GraphQLResolver<UserEvaluationDto?> {
    fun project(userEvaluationDto: UserEvaluationDto): ProjectDto {
        return projectDao.findByUserEvaluationId(userEvaluationDto.id)!!.toDto()
    }

    fun reviews(userEvaluationDto: UserEvaluationDto): List<UserReviewDto> {
        return userReviewDao.findAllByUserEvaluationId(userEvaluationDto.id).stream()
            .map { entity: UserReviewEntity -> entity.toDto() }
            .collect(Collectors.toList())
    }
}