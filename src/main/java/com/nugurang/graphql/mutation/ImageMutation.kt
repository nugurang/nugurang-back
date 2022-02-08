package com.nugurang.graphql.mutation

import com.nugurang.dto.ImageDto
import com.nugurang.service.ImageService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ImageMutation(private val imageService: ImageService) : GraphQLMutationResolver {

    fun createImage(address: String): ImageDto {
        return imageService.createImage(address).toDto()
    }

    fun deleteImage(id: Long): Long {
        imageService.deleteImage(id)
        return id
    }
}