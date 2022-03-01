package com.nugurang.graphql.mutation

import com.nugurang.dto.UserDto
import com.nugurang.dto.UserInputDto
import com.nugurang.mapper.UserMapper
import com.nugurang.service.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class UserMutation(
    private val userService: UserService,
    private val userMapper: UserMapper
) : GraphQLMutationResolver {

    fun createCurrentUser(userInputDto: UserInputDto): UserDto {
        return userService.createUser(userInputDto).let(userMapper::toDto)
    }

    fun updateCurrentUser(userInputDto: UserInputDto): UserDto {
        return userService.updateCurrentUser(userInputDto).let(userMapper::toDto)
    }

    fun deleteUser(userId: Long): Long {
        return userService.deleteUser(userId)
    }

    fun deleteCurrentUser(): Long {
        return userService.deleteCurrentUser()
    }
}