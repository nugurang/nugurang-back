package com.nugurang.graphql.query;

import com.nugurang.dto.WorkDto;
import com.nugurang.service.WorkService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class WorkQuery implements GraphQLQueryResolver {
    private final WorkService workService;

    public Optional<WorkDto> getWork(Long id) {
        return workService.getWork(id).map(entity -> entity.toDto());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public WorkQuery(final WorkService workService) {
        this.workService = workService;
    }
    //</editor-fold>
}
