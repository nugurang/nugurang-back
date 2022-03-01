package com.nugurang.graphql.resolver

import com.nugurang.dao.UserReviewDao
import com.nugurang.dto.PositionDto
import com.nugurang.dto.UserDto
import com.nugurang.dto.UserEvaluationDto
import com.nugurang.dto.UserReviewDto
import com.nugurang.entity.PositionEntity
import com.nugurang.entity.UserEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.PositionMapper
import com.nugurang.mapper.UserEvaluationMapper
import com.nugurang.mapper.UserMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserReviewResolver(
    private val userReviewDao: UserReviewDao,
    private val positionMapper: PositionMapper,
    private val userEvaluationMapper: UserEvaluationMapper,
    private val userMapper: UserMapper
) : GraphQLResolver<UserReviewDto> {

    fun position(userReviewDto: UserReviewDto): PositionDto {
        val positionEntity = userReviewDao.findByIdOrNull(userReviewDto.id)?.position
            ?: throw NotFoundException(PositionEntity::class.java)
        return positionEntity.let(positionMapper::toDto)
    }

    fun fromUser(userReviewDto: UserReviewDto): UserDto {
        val userEntity = userReviewDao.findByIdOrNull(userReviewDto.id)?.fromUser
            ?: throw NotFoundException(UserEntity::class.java)
        return userEntity.let(userMapper::toDto)
    }

    fun toUser(userReviewDto: UserReviewDto): UserDto {
        val userEntity = userReviewDao.findByIdOrNull(userReviewDto.id)?.toUser
            ?: throw NotFoundException(UserEntity::class.java)
        return userEntity.let(userMapper::toDto)
    }

    fun evaluation(userReviewDto: UserReviewDto): UserEvaluationDto {
        val userEvaluationEntity = userReviewDao.findByIdOrNull(userReviewDto.id)?.userEvaluation
            ?: throw NotFoundException(UserEntity::class.java)
        return userEvaluationEntity.let(userEvaluationMapper::toDto)
    }
}