package com.nugurang.graphql.mutation

import com.nugurang.dto.UserDto
import com.nugurang.dto.UserInputDto
import com.nugurang.service.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class UserMutation(private val userService: UserService) : GraphQLMutationResolver {

    fun createCurrentUser(userInputDto: UserInputDto): UserDto {
        return userService.createUser(userInputDto).toDto()
    }

    fun updateCurrentUser(userInputDto: UserInputDto): UserDto {
        return userService.updateCurrentUser(userInputDto).toDto()
    }

    fun deleteUser(userId: Long): Long {
        return userService.deleteUser(userId)
    }

    fun deleteCurrentUser(): Long {
        return userService.deleteCurrentUser()
    }
}