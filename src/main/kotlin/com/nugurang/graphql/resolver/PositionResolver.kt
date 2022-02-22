package com.nugurang.graphql.resolver

import com.nugurang.dao.PositionDao
import com.nugurang.dto.ImageDto
import com.nugurang.dto.PositionDto
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PositionResolver(private val positionDao: PositionDao) : GraphQLResolver<PositionDto> {
    // TODO: return nullable or non-nullable
    fun image(positionDto: PositionDto): ImageDto? {
        return positionDao.findByIdOrNull(positionDto.id)?.image?.toDto()
    }
}