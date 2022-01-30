package com.nugurang.graphql.resolver;

import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.UserReviewDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.UserEvaluationDto;
import com.nugurang.dto.UserReviewDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserEvaluationResolver implements GraphQLResolver<UserEvaluationDto> {
    private final ProjectDao projectDao;
    private final UserReviewDao userReviewDao;

    public ProjectDto project(UserEvaluationDto userEvaluationDto) {
        return projectDao.findByUserEvaluationId(userEvaluationDto.getId()).toDto();
    }

    public List<UserReviewDto> reviews(UserEvaluationDto userEvaluationDto) {
        return userReviewDao.findAllByUserEvaluationId(userEvaluationDto.getId()).stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public UserEvaluationResolver(final ProjectDao projectDao, final UserReviewDao userReviewDao) {
        this.projectDao = projectDao;
        this.userReviewDao = userReviewDao;
    }
    //</editor-fold>
}
