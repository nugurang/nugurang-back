package com.nugurang.service;

import com.nugurang.dao.ProjectDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.WorkInputDto;
import com.nugurang.entity.WorkEntity;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    private final ProjectDao projectDao;
    private final WorkDao workDao;

    public WorkEntity createWork(WorkInputDto workInputDto, Long project) {
        return workDao.save(WorkEntity.builder().name(workInputDto.getName()).opened(true).order(Optional.ofNullable(workInputDto.getOrder()).orElseGet(() -> workDao.findFirstByOrderByOrderDesc().map(prevWorkEntity -> prevWorkEntity.getOrder() + 1).orElse(0))).project(projectDao.findById(project).get()).build());
    }

    public Optional<WorkEntity> getWork(Long workId) {
        return workDao.findById(workId);
    }

    public WorkEntity updateWork(WorkInputDto workInputDto, Long workId) {
        return workDao.save(workDao.findById(workId).map(workEntity -> {
            workEntity.setName(workInputDto.getName());
            workEntity.setOpened(true);
            workEntity.setOrder(Optional.ofNullable(workInputDto.getOrder()).orElseGet(() -> workDao.findFirstByOrderByOrderDesc().map(prevWorkEntity -> prevWorkEntity.getOrder() + 1).orElse(0)));
            return workEntity;
        }).get());
    }

    public void deleteWork(Long workId) {
        workDao.deleteById(workId);
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public WorkService(final ProjectDao projectDao, final WorkDao workDao) {
        this.projectDao = projectDao;
        this.workDao = workDao;
    }
    //</editor-fold>
}
