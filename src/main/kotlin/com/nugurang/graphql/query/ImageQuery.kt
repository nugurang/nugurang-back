package com.nugurang.graphql.query

import com.nugurang.dto.ImageDto
import com.nugurang.mapper.ImageMapper
import com.nugurang.service.ImageService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class ImageQuery(
    private val imageService: ImageService,
    private val imageMapper: ImageMapper
) : GraphQLQueryResolver {

    fun getImage(id: Long): ImageDto {
        return imageMapper.toDto(imageService.getImage(id))
    }

    fun getImageByAddress(address: String): ImageDto {
        return imageMapper.toDto(imageService.getImage(address))
    }
}