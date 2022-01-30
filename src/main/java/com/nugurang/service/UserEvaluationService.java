package com.nugurang.service;

import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.UserEvaluationDao;
import com.nugurang.dao.UserHonorDao;
import com.nugurang.dao.UserReviewDao;
import com.nugurang.entity.UserEvaluationEntity;
import com.nugurang.entity.UserHonorEntity;
import com.nugurang.entity.UserReviewEntity;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserEvaluationService {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserEvaluationService.class);
    //</editor-fold>
    private final ProjectDao projectDao;
    private final UserDao userDao;
    private final UserEvaluationDao userEvaluationDao;
    private final UserHonorDao userHonorDao;
    private final UserReviewDao userReviewDao;

    @Transactional
    public void evaluateUsers() {
        log.info("user evaluation task");
        List<UserEvaluationEntity> userEvaluationEntities = userEvaluationDao.findAllByExpiresAtLessThanEqual(OffsetDateTime.now());
        // should fix
        //<editor-fold defaultstate="collapsed" desc="delombok">
        List<UserReviewEntity> userReviewEntities = userReviewDao.findAllByToUserIdIn(userDao.findAllByProjectIdIn(userEvaluationEntities.stream().map(userEvaluationEntity -> Optional.ofNullable(projectDao.findByUserEvaluationId(userEvaluationEntity.getId())).get()).map(projectEntity -> projectEntity.getId()).collect(Collectors.toList())).stream().map(userEntity -> userEntity.getId()).collect(Collectors.toList()));
        userHonorDao.saveAll(userReviewEntities.stream().map(userReviewEntity -> {
            UserHonorEntity userHonorEntity = Optional.ofNullable(userHonorDao.findByUserIdAndPositionId(userReviewEntity.getToUser().getId(), userReviewEntity.getPosition().getId())).orElseGet(() -> UserHonorEntity.builder().honor(0).user(userReviewEntity.getToUser()).position(userReviewEntity.getPosition()).build());
            userHonorEntity.setHonor(userHonorEntity.getHonor() + userReviewEntity.getHonor());
            return userHonorEntity;
        }).collect(Collectors.toList()));
        userReviewDao.deleteAllByIdIn(userReviewEntities.stream().map(userReviewEntity -> userReviewEntity.getId()).collect(Collectors.toList()));
        userEvaluationDao.deleteAllByIdIn(userEvaluationEntities.stream().map(userEvaluationEntity -> userEvaluationEntity.getId()).collect(Collectors.toList()));
    }
        //</editor-fold>

    @SuppressWarnings("all")
    
    public UserEvaluationService(final ProjectDao projectDao, final UserDao userDao, final UserEvaluationDao userEvaluationDao, final UserHonorDao userHonorDao, final UserReviewDao userReviewDao) {
        this.projectDao = projectDao;
        this.userDao = userDao;
        this.userEvaluationDao = userEvaluationDao;
        this.userHonorDao = userHonorDao;
        this.userReviewDao = userReviewDao;
    }
}
