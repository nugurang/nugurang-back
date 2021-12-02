package com.nugurang.service;

import com.nugurang.dao.BoardDao;
import com.nugurang.dto.BoardInputDto;
import com.nugurang.entity.BoardEntity;
import com.nugurang.exception.NotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;

    public BoardEntity createBoard(BoardInputDto boardInputDto) {
        return boardDao.save(
            BoardEntity
            .builder()
            .name(boardInputDto.getName())
            .build()
        );
    }

    public BoardEntity getBoard(Long id) throws NotFoundException {
        return boardDao
            .findById(id)
            .orElseThrow(() -> NotFoundException.builder().message("Board not found").objectName("Board").build());
    }

    public Optional<BoardEntity> getBoard(String name) {
        return boardDao.findByName(name);
    }

    public List<BoardEntity> getBoards() {
        return boardDao.findAll();
    }

    public List<BoardEntity> getBoards(List<String> names) {
        return boardDao.findAllByNameIn(names);
    }

    public BoardEntity updateBoard(BoardInputDto boardInputDto, Long boardId) {
        BoardEntity boardEntity = boardDao.getById(boardId);
        boardEntity.setName(boardInputDto.getName());
        return boardDao.save(boardEntity);
    }

    public void deleteBoard(Long id) {
        boardDao.deleteById(id);
    }
}
