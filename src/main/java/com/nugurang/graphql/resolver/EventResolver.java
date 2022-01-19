package com.nugurang.graphql.resolver;

import com.nugurang.dao.ImageDao;
import com.nugurang.dao.MatchRequestDao;
import com.nugurang.dto.EventDto;
import com.nugurang.dto.ImageDto;
import com.nugurang.dto.MatchRequestDto;
import com.nugurang.dto.TagDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class EventResolver implements GraphQLResolver<EventDto> {
    private final ImageDao imageDao;
    private final MatchRequestDao matchRequestDao;

    public List<ImageDto> images(EventDto eventDto) {
        return null;
    }

    public List<TagDto> tags(EventDto eventDto) {
        return null;
    }

    public List<MatchRequestDto> matchRequests(EventDto eventDto) {
        return matchRequestDao.findAllByEventId(eventDto.getId()).stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public EventResolver(final ImageDao imageDao, final MatchRequestDao matchRequestDao) {
        this.imageDao = imageDao;
        this.matchRequestDao = matchRequestDao;
    }
    //</editor-fold>
}
