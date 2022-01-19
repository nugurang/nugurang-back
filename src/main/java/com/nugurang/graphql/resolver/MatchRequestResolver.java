package com.nugurang.graphql.resolver;

import com.nugurang.dao.MatchRequestDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.MatchRequestDto;
import com.nugurang.dto.MatchTypeDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

@Service
public class MatchRequestResolver implements GraphQLResolver<MatchRequestDto> {
    private final MatchRequestDao matchRequestDao;

    public MatchTypeDto type(MatchRequestDto matchRequestDto) {
        return matchRequestDao.findById(matchRequestDto.getId()).get().getType().toDto();
    }

    public EventDto event(MatchRequestDto matchRequestDto) {
        return matchRequestDao.findById(matchRequestDto.getId()).get().getEvent().toDto();
    }

    public UserDto user(MatchRequestDto matchRequestDto) {
        return matchRequestDao.findById(matchRequestDto.getId()).get().getUser().toDto();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public MatchRequestResolver(final MatchRequestDao matchRequestDao) {
        this.matchRequestDao = matchRequestDao;
    }
    //</editor-fold>
}
