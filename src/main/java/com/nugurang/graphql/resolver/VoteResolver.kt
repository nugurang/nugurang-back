package com.nugurang.graphql.resolver

import com.nugurang.dao.ArticleDao
import com.nugurang.dao.UserDao
import com.nugurang.dao.VoteTypeDao
import com.nugurang.dto.ArticleDto
import com.nugurang.dto.UserDto
import com.nugurang.dto.VoteDto
import com.nugurang.dto.VoteTypeDto
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class VoteResolver(
    private val userDao: UserDao,
    private val articledDao: ArticleDao,
    private val voteTypeDao: VoteTypeDao
) :

    GraphQLResolver<VoteDto?> {
    fun user(voteDto: VoteDto?): UserDto? {
        return null
    }

    fun article(voteDto: VoteDto?): ArticleDto? {
        return null
    }

    fun voteType(voteDto: VoteDto?): VoteTypeDto? {
        return null
    }
}