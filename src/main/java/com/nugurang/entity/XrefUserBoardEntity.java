package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_user_board", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "board"})})
public class XrefUserBoardEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;
    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private RoleEntity role;

    public XrefUserBoardEntity(UserEntity user, BoardEntity board, RoleEntity role) {
        this.user = user;
        this.board = board;
        this.role = role;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class XrefUserBoardEntityBuilder {
        @SuppressWarnings("all")
        private UserEntity user;
        @SuppressWarnings("all")
        private BoardEntity board;
        @SuppressWarnings("all")
        private RoleEntity role;

        @SuppressWarnings("all")
        XrefUserBoardEntityBuilder() {
        }

        @SuppressWarnings("all")
        public XrefUserBoardEntity.XrefUserBoardEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        public XrefUserBoardEntity.XrefUserBoardEntityBuilder board(final BoardEntity board) {
            this.board = board;
            return this;
        }

        @SuppressWarnings("all")
        public XrefUserBoardEntity.XrefUserBoardEntityBuilder role(final RoleEntity role) {
            this.role = role;
            return this;
        }

        @SuppressWarnings("all")
        public XrefUserBoardEntity build() {
            return new XrefUserBoardEntity(this.user, this.board, this.role);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "XrefUserBoardEntity.XrefUserBoardEntityBuilder(user=" + this.user + ", board=" + this.board + ", role=" + this.role + ")";
        }
    }

    @SuppressWarnings("all")
    public static XrefUserBoardEntity.XrefUserBoardEntityBuilder builder() {
        return new XrefUserBoardEntity.XrefUserBoardEntityBuilder();
    }

    @SuppressWarnings("all")
    protected XrefUserBoardEntity() {
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public UserEntity getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    public BoardEntity getBoard() {
        return this.board;
    }

    @SuppressWarnings("all")
    public RoleEntity getRole() {
        return this.role;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    public void setBoard(final BoardEntity board) {
        this.board = board;
    }

    @SuppressWarnings("all")
    public void setRole(final RoleEntity role) {
        this.role = role;
    }
    //</editor-fold>
}
