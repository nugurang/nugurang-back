package com.nugurang.test.dao

import com.nugurang.config.JpaConfig
import com.nugurang.dao.BoardDao
import com.nugurang.dao.ThreadDao
import com.nugurang.dao.UserDao
import com.nugurang.entity.BoardEntity
import com.nugurang.entity.ThreadEntity
import com.nugurang.entity.UserEntity
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import java.time.OffsetDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@DataJpaTest
@Import(JpaConfig::class)
internal class BoardDaoTests(
    private val boardDao: BoardDao,
    private val threadDao: ThreadDao,
    private val userDao: UserDao
) {
    @Test
    fun `Should delete all threads when a board is deleted`() {
        val boardEntity = BoardEntity(name = "test")
        boardDao.save(boardEntity)
        assertNotEquals(boardEntity.id, null)
        assertEquals(boardDao.findAll().size, 1)

        val blogBoardEntity = BoardEntity(name = "test2")
        boardDao.save(blogBoardEntity)
        assertEquals(boardDao.findAll().size, 2)

        val userEntity = UserEntity(
            oauth2Provider = "test",
            oauth2Id = "test",
            name = "test",
            email = "test@test.com",
            blog = blogBoardEntity
        )
        userDao.save(userEntity)
        assertEquals(userDao.findAll().size, 1)

        val threadEntity = ThreadEntity(
            name = "test",
            createdAt = OffsetDateTime.now(),
            board = boardEntity,
            user = userEntity
        )
        threadDao.save(threadEntity)
        assertEquals(threadDao.findAll().size, 1)

        boardDao.delete(boardEntity)
        assertEquals(boardDao.findAll().size, 1)
        assertEquals(userDao.findAll().size, 1)
        assertEquals(threadDao.findAll().size, 0)
    }
}