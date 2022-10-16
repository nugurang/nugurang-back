package com.nugurang.graphql.mutation

import com.nugurang.dto.BoardDto
import com.nugurang.dto.BoardInputDto
import com.nugurang.mapper.BoardMapper
import com.nugurang.service.BoardService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class BoardMutation(
    private val boardService: BoardService,
    private val boardMapper: BoardMapper
) : GraphQLMutationResolver {

    fun createBoard(boardInputDto: BoardInputDto): BoardDto = boardMapper
        .toDto(boardService.createBoard(boardInputDto))

    fun updateBoard(boardInputDto: BoardInputDto, boardId: Long): BoardDto = boardService
        .updateBoard(boardInputDto, boardId)
        .let(boardMapper::toDto)

    fun deleteBoard(boardId: Long): Long {
        boardService.deleteBoard(boardId)
        return boardId
    }
}