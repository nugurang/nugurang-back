package com.nugurang.graphql.resolver;

import com.nugurang.dao.UserHonorDao;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserHonorDto;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

@Service
public class UserHonorResolver implements GraphQLResolver<UserHonorDto> {
    private final UserHonorDao userHonorDao;

    public UserDto user(UserHonorDto userHonorDto) {
        return userHonorDao.findById(userHonorDto.getId()).map(userHonorEntity -> userHonorEntity.getUser()).map(userEntity -> userEntity.toDto()).get();
    }

    public PositionDto position(UserHonorDto userHonorDto) {
        return userHonorDao.findById(userHonorDto.getId()).map(userHonorEntity -> userHonorEntity.getPosition()).map(positionEntity -> positionEntity.toDto()).get();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public UserHonorResolver(final UserHonorDao userHonorDao) {
        this.userHonorDao = userHonorDao;
    }
    //</editor-fold>
}
