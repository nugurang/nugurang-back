package com.nugurang.service

import com.nugurang.dao.BoardDao
import com.nugurang.dto.BoardInputDto
import com.nugurang.entity.BoardEntity
import com.nugurang.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.acls.domain.BasePermission
import org.springframework.security.acls.domain.ObjectIdentityImpl
import org.springframework.security.acls.domain.PrincipalSid
import org.springframework.security.acls.model.MutableAclService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BoardService(
    private val boardDao: BoardDao,
    private val mutableAclService: MutableAclService,
    private val oauth2Service: OAuth2Service
) {
    @Transactional
    fun createBoard(boardInputDto: BoardInputDto): BoardEntity {
        val board = boardDao.save(
            BoardEntity(
                name = boardInputDto.name
            )
        )
        val oid = ObjectIdentityImpl(BoardEntity::class.java, board.id)
        val acl = mutableAclService.createAcl(oid)
        val auth = oauth2Service.getOAuth2AuthToken()
        val sid = PrincipalSid(auth)
        acl.insertAce(acl.entries.size, BasePermission.READ, sid, true)
        acl.insertAce(acl.entries.size, BasePermission.WRITE, sid, true)
        acl.insertAce(acl.entries.size, BasePermission.DELETE, sid, true)
        /*
        acl.insertAce(acl.getEntries().size(), BasePermission.READ, new GrantedAuthoritySid("ADMIN"), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, new GrantedAuthoritySid("ADMIN"), true);
        acl.insertAce(acl.getEntries().size(), BasePermission.DELETE, new GrantedAuthoritySid("ADMIN"), true);
        */
        return board
    }

    fun getBoard(id: Long): BoardEntity = boardDao.findByIdOrNull(id) ?: throw NotFoundException(
        BoardEntity::class.java,
    )

    fun getBoard(name: String): BoardEntity = boardDao.findByName(name) ?: throw NotFoundException(
        BoardEntity::class.java,
    )

    fun getBoards(): List<BoardEntity> = boardDao.findAll()

    fun getBoards(names: List<String>): List<BoardEntity> = boardDao.findAllByNameIn(names)

    fun updateBoard(boardInputDto: BoardInputDto, boardId: Long): BoardEntity {
        val boardEntity = boardDao.getById(boardId)
        boardEntity.name = boardInputDto.name
        return boardDao.save(boardEntity)
    }

    fun deleteBoard(id: Long) = boardDao.deleteById(id)
}
