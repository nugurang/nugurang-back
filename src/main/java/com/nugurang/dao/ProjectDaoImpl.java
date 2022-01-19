package com.nugurang.dao;

import static com.nugurang.entity.QProjectEntity.projectEntity;
import static com.nugurang.entity.QXrefUserProjectEntity.xrefUserProjectEntity;
import com.nugurang.entity.ProjectEntity;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoImpl implements ProjectDaoCustom {
    private final JPAQueryFactory queryFactory;

    public Page<ProjectEntity> findAllByUserId(Long user, Pageable pageable) {
        QueryResults<ProjectEntity> results = queryFactory.selectFrom(projectEntity).innerJoin(xrefUserProjectEntity).on(xrefUserProjectEntity.project.id.eq(projectEntity.id)).where(xrefUserProjectEntity.user.id.eq(user)).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ProjectDaoImpl(final JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
    //</editor-fold>
}
