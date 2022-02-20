package com.nugurang.graphql.query

import com.nugurang.dto.UserDto
import com.nugurang.service.UserService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserQuery(private val userService: UserService) : GraphQLQueryResolver {
    fun getCurrentUser(): UserDto {
        return userService.getCurrentUser().toDto()
    }

    fun getUser(id: Long): UserDto {
        return userService.getUser(id).toDto()
    }

    fun getUserByName(name: String): UserDto {
        return userService.getUser(name).toDto()
    }

    fun getUsers(page: Int, pageSize: Int): List<UserDto> {
        return userService.getUsers(PageRequest.of(page, pageSize)).map { it.toDto() }
    }

    fun getUsersByName(name: String, page: Int, pageSize: Int): List<UserDto> {
        return userService.getUsers(name, PageRequest.of(page, pageSize)).map { it.toDto() }
    }
}