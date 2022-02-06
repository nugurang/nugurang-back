package com.nugurang.graphql.query;

import com.nugurang.dto.EventDto;
import com.nugurang.service.EventService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EventQuery implements GraphQLQueryResolver {
    private final EventService eventService;

    public Optional<EventDto> getEvent(Long id) {
        return Optional.ofNullable(eventService.getEvent(id)).map(entity -> entity.toDto());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public EventQuery(final EventService eventService) {
        this.eventService = eventService;
    }
    //</editor-fold>
}
