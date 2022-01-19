package com.nugurang.graphql.resolver;

import com.nugurang.dao.NotificationDao;
import com.nugurang.dao.NotificationDataDao;
import com.nugurang.dto.NotificationDto;
import com.nugurang.dto.NotificationTypeDto;
import com.nugurang.dto.UserDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class NotificationResolver implements GraphQLResolver<NotificationDto> {
    private final NotificationDao notificationDao;
    private final NotificationDataDao notificationDataDao;

    public UserDto user(NotificationDto notificationDto) {
        return notificationDao.findById(notificationDto.getId()).get().getUser().toDto();
    }

    public List<String> data(NotificationDto notificationDto) {
        return notificationDataDao.findAllByNotificationIdOrderByIdAsc(notificationDto.getId()).stream().map(entity -> entity.getValue()).collect(Collectors.toList());
    }

    public NotificationTypeDto type(NotificationDto notificationDto) {
        return notificationDao.findById(notificationDto.getId()).get().getNotificationType().toDto();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public NotificationResolver(final NotificationDao notificationDao, final NotificationDataDao notificationDataDao) {
        this.notificationDao = notificationDao;
        this.notificationDataDao = notificationDataDao;
    }
    //</editor-fold>
}
