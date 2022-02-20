package com.nugurang.graphql.query

import com.nugurang.dto.BoardDto
import com.nugurang.service.BoardService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class BoardQuery(private val boardService: BoardService) : GraphQLQueryResolver {

    fun getBoard(id: Long): BoardDto {
        return boardService.getBoard(id).toDto()
    }

    fun getBoardByName(name: String): BoardDto {
        return boardService.getBoard(name).toDto()

    }

    fun boards(): List<BoardDto> {
        return boardService.getBoards().map { it.toDto() }
    }

    fun getBoardsByNames(names: List<String>): List<BoardDto> {
        return boardService.getBoards(names).map { it.toDto() }
    }
}