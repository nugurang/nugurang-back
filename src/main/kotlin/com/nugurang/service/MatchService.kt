package com.nugurang.service

import com.nugurang.dao.MatchRequestDao
import com.nugurang.dao.MatchTypeDao
import com.nugurang.entity.MatchRequestEntity
import com.nugurang.entity.MatchTypeEntity
import org.springframework.stereotype.Service

@Service
class MatchService(
    private val matchRequestDao: MatchRequestDao,
    private val matchTypeDao: MatchTypeDao,
    private val userService: UserService
) {

    fun getMatchRequests(): List<MatchRequestEntity> {
        return matchRequestDao.findAllByUserId(userService.getCurrentUser().id!!)
    }

    fun getMatchTypes(): List<MatchTypeEntity> {
        return matchTypeDao.findAll()
    }
}
