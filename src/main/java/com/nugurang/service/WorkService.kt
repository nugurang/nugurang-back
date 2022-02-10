package com.nugurang.service

import com.nugurang.dao.ProjectDao
import com.nugurang.dao.WorkDao
import com.nugurang.dto.WorkInputDto
import com.nugurang.entity.ProjectEntity
import com.nugurang.entity.WorkEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class WorkService(private val projectDao: ProjectDao, private val workDao: WorkDao) {

    fun createWork(workInputDto: WorkInputDto, projectId: Long): WorkEntity {
        return workDao.save(
            WorkEntity
            .builder()
            .name(workInputDto.name)
            .opened(true)
            .order(
                workInputDto.order ?: (
                    workDao.findFirstByOrderByOrderDesc()
                    ?.let { prevWorkEntity -> prevWorkEntity.order + 1 }
                    ?: 0
                )
            ).project(projectDao.findByIdOrNull(projectId) ?: throw NotFoundException(ProjectEntity::class.java))
            .build()
        )
    }

    fun getWork(workId: Long): WorkEntity {
        return workDao.findByIdOrNull(workId) ?: throw NotFoundException(WorkEntity::class.java)
    }

    fun updateWork(workInputDto: WorkInputDto, workId: Long): WorkEntity {
        return workDao.save(
            workDao.findByIdOrNull(workId)?.let { workEntity ->
                workEntity.name = workInputDto.name
                workEntity.opened = true
                workEntity.order = workInputDto.order ?: (
                    workDao.findFirstByOrderByOrderDesc()
                    ?.let { prevWorkEntity -> prevWorkEntity.order + 1 }
                    ?: 0
                )
                workEntity
            } ?: throw NotFoundException(WorkEntity::class.java)
        )
    }

    fun deleteWork(workId: Long) {
        workDao.deleteById(workId)
    }
}