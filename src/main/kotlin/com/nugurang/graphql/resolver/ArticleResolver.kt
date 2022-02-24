package com.nugurang.graphql.resolver

import com.nugurang.dao.ArticleDao
import com.nugurang.dao.ImageDao
import com.nugurang.dao.VoteDao
import com.nugurang.dao.VoteTypeDao
import com.nugurang.dto.*
import com.nugurang.entity.ThreadEntity
import com.nugurang.entity.UserEntity
import com.nugurang.entity.VoteTypeEntity
import com.nugurang.exception.NotFoundException
import com.nugurang.mapper.ArticleMapper
import com.nugurang.mapper.ImageMapper
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ArticleResolver(
    private val articleDao: ArticleDao,
    private val imageDao: ImageDao,
    private val voteDao: VoteDao,
    private val voteTypeDao: VoteTypeDao,
    private val articleMapper: ArticleMapper,
    private val imageMapper: ImageMapper
) : GraphQLResolver<ArticleDto> {

    fun thread(articleDto: ArticleDto): ThreadDto {
        return articleDao.findByIdOrNull(articleDto.id)?.thread?.toDto()
        ?: throw NotFoundException(ThreadEntity::class.java)
    }

    fun user(articleDto: ArticleDto): UserDto {
        return articleDao.findByIdOrNull(articleDto.id)?.user?.toDto()
        ?: throw NotFoundException(UserEntity::class.java)
    }

    // TODO: should we return nullable or non-nullable with an exception?
    fun parent(articleDto: ArticleDto): ArticleDto? {
        return articleDao.findByIdOrNull(articleDto.id)?.parent?.let(articleMapper::toDto)
    }

    fun images(articleDto: ArticleDto): List<ImageDto> {
        return imageDao.findAllByArticleId(articleDto.id).map(imageMapper::toDto)
    }

    fun tags(articleDto: ArticleDto): List<TagDto> {
        return listOf()
    }

    fun viewCount(articleDto: ArticleDto): Long {
        return voteDao.countByArticleIdAndVoteTypeId(
            articleDto.id,
            voteTypeDao.findByName("VIEW")?.id
            ?: throw NotFoundException(VoteTypeEntity::class.java)
        )
    }

    fun upCount(articleDto: ArticleDto): Long {
        return voteDao.countByArticleIdAndVoteTypeId(
            articleDto.id,
            voteTypeDao.findByName("UP")?.id
            ?: throw NotFoundException(VoteTypeEntity::class.java)
        )
    }

    fun downCount(articleDto: ArticleDto): Long {
        return voteDao.countByArticleIdAndVoteTypeId(
            articleDto.id,
            voteTypeDao.findByName("DOWN")?.id
            ?: throw NotFoundException(VoteTypeEntity::class.java)
        )
    }

    fun starCount(articleDto: ArticleDto): Long {
        return voteDao.countByArticleIdAndVoteTypeId(
            articleDto.id,
            voteTypeDao.findByName("STAR")?.id
            ?: throw NotFoundException(VoteTypeEntity::class.java)
        )
    }
}