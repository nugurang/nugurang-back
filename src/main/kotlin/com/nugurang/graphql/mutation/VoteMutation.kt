package com.nugurang.graphql.mutation

import com.nugurang.dto.VoteDto
import com.nugurang.dto.VoteInputDto
import com.nugurang.service.VoteService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class VoteMutation(private val voteService: VoteService) : GraphQLMutationResolver {

    fun createVote(voteInputDto: VoteInputDto): VoteDto {
        return voteService.createVote(voteInputDto).toDto()
    }

    fun updateVote(voteInputDto: VoteInputDto, voteId: Long): VoteDto {
        return voteService.updateVote(voteInputDto, voteId).toDto()
    }

    fun deleteVote(voteId: Long): Long {
        voteService.deleteVote(voteId)
        return voteId
    }
}