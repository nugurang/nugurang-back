package com.nugurang.graphql.query

import com.nugurang.dto.UserDto
import com.nugurang.mapper.UserMapper
import com.nugurang.service.UserService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserQuery(
    private val userService: UserService,
    private val userMapper: UserMapper
) : GraphQLQueryResolver {

    fun getCurrentUser(): UserDto {
        return userMapper.toDto(userService.getCurrentUser())
    }

    fun getUser(id: Long): UserDto {
        return userMapper.toDto(userService.getUser(id))
    }

    fun getUserByName(name: String): UserDto {
        return userMapper.toDto(userService.getUser(name))
    }

    fun getUsers(page: Int, pageSize: Int): List<UserDto> {
        return userService.getUsers(PageRequest.of(page, pageSize)).map(userMapper::toDto)
    }

    fun getUsersByName(name: String, page: Int, pageSize: Int): List<UserDto> {
        return userService.getUsers(name, PageRequest.of(page, pageSize)).map(userMapper::toDto)
    }
}