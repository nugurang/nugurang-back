package com.nugurang.graphql.resolver;

import com.nugurang.dao.UserReviewDao;
import com.nugurang.dto.PositionDto;
import com.nugurang.dto.UserDto;
import com.nugurang.dto.UserEvaluationDto;
import com.nugurang.dto.UserReviewDto;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

@Service
public class UserReviewResolver implements GraphQLResolver<UserReviewDto> {
    private final UserReviewDao userReviewDao;

    public PositionDto position(UserReviewDto userReviewDto) {
        return userReviewDao.findById(userReviewDto.getId()).get().getPosition().toDto();
    }

    public UserDto fromUser(UserReviewDto userReviewDto) {
        return userReviewDao.findById(userReviewDto.getId()).get().getFromUser().toDto();
    }

    public UserDto toUser(UserReviewDto userReviewDto) {
        return userReviewDao.findById(userReviewDto.getId()).get().getToUser().toDto();
    }

    public UserEvaluationDto evaluation(UserReviewDto userReviewDto) {
        return userReviewDao.findById(userReviewDto.getId()).get().getUserEvaluation().toDto();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public UserReviewResolver(final UserReviewDao userReviewDao) {
        this.userReviewDao = userReviewDao;
    }
    //</editor-fold>
}
