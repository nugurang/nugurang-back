package com.nugurang.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ThreadDaoImpl implements ThreadDaoCustom {
    private final JPAQueryFactory queryFactory;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ThreadDaoImpl(final JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
    //</editor-fold>
}
