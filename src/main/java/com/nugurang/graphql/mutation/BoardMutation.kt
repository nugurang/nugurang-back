package com.nugurang.graphql.mutation

import com.nugurang.dto.BoardDto
import com.nugurang.dto.BoardInputDto
import com.nugurang.service.BoardService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class BoardMutation(private val boardService: BoardService) : GraphQLMutationResolver {

    fun createBoard(boardInputDto: BoardInputDto): BoardDto {
        return boardService.createBoard(boardInputDto).toDto()
    }

    fun updateBoard(boardInputDto: BoardInputDto, boardId: Long): BoardDto {
        return boardService.updateBoard(boardInputDto, boardId).toDto()
    }

    fun deleteBoard(boardId: Long): Long {
        boardService.deleteBoard(boardId)
        return boardId
    }
}