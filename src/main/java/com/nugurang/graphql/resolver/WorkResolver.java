package com.nugurang.graphql.resolver;

import com.nugurang.dao.TaskDao;
import com.nugurang.dao.WorkDao;
import com.nugurang.dto.ProjectDto;
import com.nugurang.dto.TaskDto;
import com.nugurang.dto.WorkDto;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class WorkResolver implements GraphQLResolver<WorkDto> {
    private final TaskDao taskDao;
    private final WorkDao workDao;

    public ProjectDto project(WorkDto workDto) {
        return workDao.findById(workDto.getId()).map(workEntity -> workEntity.getProject()).map(projectEntity -> projectEntity.toDto()).get();
    }

    public List<TaskDto> tasks(WorkDto workDto) {
        return taskDao.findAllByWorkId(workDto.getId()).stream().map(entity -> entity.toDto()).collect(Collectors.toList());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public WorkResolver(final TaskDao taskDao, final WorkDao workDao) {
        this.taskDao = taskDao;
        this.workDao = workDao;
    }
    //</editor-fold>
}
