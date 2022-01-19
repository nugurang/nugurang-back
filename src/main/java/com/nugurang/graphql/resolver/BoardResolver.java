package com.nugurang.graphql.resolver;

import com.nugurang.dao.ThreadDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dto.BoardDto;
import com.nugurang.dto.ThreadDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BoardResolver implements GraphQLResolver<BoardDto> {
    private final UserDao userDao;
    private final ThreadDao threadDao;

    public List<UserDto> getUsers(BoardDto boardDto, Integer page, Integer pageSize) {
        return userDao.findAllByBoardId(boardDto.getId(), PageRequest.of(page, pageSize)).getContent().stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    public List<ThreadDto> getThreads(BoardDto boardDto, Integer page, Integer pageSize) {
        return threadDao.findAllByBoardIdOrderByCreatedAtDesc(boardDto.getId(), PageRequest.of(page, pageSize)).getContent().stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public BoardResolver(final UserDao userDao, final ThreadDao threadDao) {
        this.userDao = userDao;
        this.threadDao = threadDao;
    }
    //</editor-fold>
}
