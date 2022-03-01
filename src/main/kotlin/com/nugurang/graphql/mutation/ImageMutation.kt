package com.nugurang.graphql.mutation

import com.nugurang.dto.ImageDto
import com.nugurang.mapper.ImageMapper
import com.nugurang.service.ImageService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ImageMutation(
    private val imageService: ImageService,
    private val imageMapper: ImageMapper
) : GraphQLMutationResolver {

    fun createImage(address: String): ImageDto {
        return imageMapper.toDto(imageService.createImage(address))
    }

    fun deleteImage(id: Long): Long {
        imageService.deleteImage(id)
        return id
    }
}