package com.nugurang.graphql.query

import com.nugurang.dto.BoardDto
import com.nugurang.mapper.BoardMapper
import com.nugurang.service.BoardService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class BoardQuery(
    private val boardService: BoardService,
    private val boardMapper: BoardMapper
) : GraphQLQueryResolver {

    fun getBoard(id: Long): BoardDto {
        return boardService.getBoard(id).let(boardMapper::toDto)
    }

    fun getBoardByName(name: String): BoardDto {
        return boardService.getBoard(name).let(boardMapper::toDto)

    }

    fun boards(): List<BoardDto> {
        return boardService.getBoards().map(boardMapper::toDto)
    }

    fun getBoardsByNames(names: List<String>): List<BoardDto> {
        return boardService.getBoards(names).map(boardMapper::toDto)
    }
}