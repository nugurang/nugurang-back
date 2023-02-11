package com.nugurang.test.dao

import com.nugurang.config.JpaConfig
import com.nugurang.dao.BoardDao
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import kotlin.test.Test

@DataJpaTest
@Import(JpaConfig::class)
internal class BoardDaoTests(
    private val boardDao: BoardDao,
) {
    @Test
    fun test() {
        boardDao.findAll()
    }
}