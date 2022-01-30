package com.nugurang.service;

import com.nugurang.constant.ProgressName;
import com.nugurang.dao.PositionDao;
import com.nugurang.dao.ProgressDao;
import com.nugurang.dao.TaskDao;
import com.nugurang.dao.UserDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dao.XrefTaskPositionDao;
import com.nugurang.dao.XrefUserTaskDao;
import com.nugurang.dto.TaskInputDto;
import com.nugurang.entity.TaskEntity;
import com.nugurang.entity.XrefTaskPositionEntity;
import com.nugurang.entity.XrefUserTaskEntity;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {
    private final PositionDao positionDao;
    private final ProgressDao progressDao;
    private final TaskDao taskDao;
    private final UserDao userDao;
    private final WorkDao workDao;
    private final XrefTaskPositionDao xrefTaskPositionDao;
    private final XrefUserTaskDao xrefUserTaskDao;

    @Transactional
    public TaskEntity createTask(TaskInputDto taskInputDto, Long work) {
        TaskEntity taskEntity = taskDao.save(TaskEntity.builder().name(taskInputDto.getName()).order(Optional.ofNullable(taskInputDto.getOrder()).orElseGet(() -> Optional.ofNullable(taskDao.findFirstByOrderByOrderDesc()).map(prevTaskEntity -> prevTaskEntity.getOrder() + 1).orElse(0))).difficulty(Optional.of(taskInputDto.getDifficulty()).orElse(1)).work(workDao.findById(work).get()).progress(Optional.ofNullable(taskInputDto.getProgress()).map(progressId -> progressDao.findById(progressId).get()).orElseGet(() -> Optional.ofNullable(progressDao.findByName(ProgressName.TODO.name())).get())).build());
        xrefUserTaskDao.saveAll(taskInputDto.getUsers().stream().map(userId -> userDao.findById(userId).get()).map(userEntity -> XrefUserTaskEntity.builder().user(userEntity).task(taskEntity).build()).collect(Collectors.toList()));
        xrefTaskPositionDao.saveAll(taskInputDto.getPositions().stream().map(positionId -> positionDao.findById(positionId).get()).map(positionEntity -> XrefTaskPositionEntity.builder().task(taskEntity).position(positionEntity).build()).collect(Collectors.toList()));
        return taskEntity;
    }

    public Optional<TaskEntity> getTask(Long taskId) {
        return taskDao.findById(taskId);
    }

    public TaskEntity updateTask(TaskInputDto taskInputDto, Long taskId) {
        TaskEntity taskEntity = taskDao.findById(taskId).get();
        taskEntity.setName(taskInputDto.getName());
        if (Optional.ofNullable(taskInputDto.getOrder()).isPresent()) taskEntity.setOrder(taskInputDto.getOrder());
        if (Optional.ofNullable(taskInputDto.getDifficulty()).isPresent()) taskEntity.setDifficulty(taskInputDto.getDifficulty());
        if (Optional.ofNullable(taskInputDto.getProgress()).isPresent()) {
            taskEntity.setProgress(progressDao.findById(taskInputDto.getProgress()).get());
        }
        return taskDao.save(taskEntity);
    }

    public Long deleteTask(Long taskId) {
        taskDao.deleteById(taskId);
        return taskId;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public TaskService(final PositionDao positionDao, final ProgressDao progressDao, final TaskDao taskDao, final UserDao userDao, final WorkDao workDao, final XrefTaskPositionDao xrefTaskPositionDao, final XrefUserTaskDao xrefUserTaskDao) {
        this.positionDao = positionDao;
        this.progressDao = progressDao;
        this.taskDao = taskDao;
        this.userDao = userDao;
        this.workDao = workDao;
        this.xrefTaskPositionDao = xrefTaskPositionDao;
        this.xrefUserTaskDao = xrefUserTaskDao;
    }
    //</editor-fold>
}
