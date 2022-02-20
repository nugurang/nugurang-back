package com.nugurang.dao

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ThreadDaoImpl(private val queryFactory: JPAQueryFactory) : ThreadDaoCustom