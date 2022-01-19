package com.nugurang.graphql.query;

import com.nugurang.dto.NotificationDto;
import com.nugurang.service.NotificationService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class NotificationQuery implements GraphQLQueryResolver {
    private final NotificationService notificationService;

    public Optional<NotificationDto> getNotification(Long id) {
        return notificationService.getNotification(id).map(entity -> entity.toDto());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public NotificationQuery(final NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    //</editor-fold>
}
