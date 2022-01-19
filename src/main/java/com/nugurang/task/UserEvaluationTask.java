package com.nugurang.task;

import com.nugurang.service.UserEvaluationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserEvaluationTask {
    @SuppressWarnings("all")
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserEvaluationTask.class);
    private final UserEvaluationService userEvaluationService;

    @Scheduled(fixedDelay = 10000)
    private void evaluateUsers() {
        log.info("user evaluation task");
        userEvaluationService.evaluateUsers();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public UserEvaluationTask(final UserEvaluationService userEvaluationService) {
        this.userEvaluationService = userEvaluationService;
    }
    //</editor-fold>
}
