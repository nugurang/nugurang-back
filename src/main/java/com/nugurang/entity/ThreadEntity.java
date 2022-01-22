package com.nugurang.entity;

import com.nugurang.dto.ThreadDto;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "thread")
public class ThreadEntity implements BaseEntity<ThreadDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime modifiedAt;
    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "xref_user_team")
    private XrefUserTeamEntity xrefUserTeam;
    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;
    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<XrefThreadTagEntity> xrefTags = new ArrayList<>();

    public ThreadEntity(String name, BoardEntity board, UserEntity user, XrefUserTeamEntity xrefUserTeam, EventEntity event) {
        this.name = name;
        this.board = board;
        this.user = user;
        this.xrefUserTeam = xrefUserTeam;
        this.event = event;
    }

    @Override
    public ThreadDto toDto() {
        return new ThreadDto(id, name, createdAt, modifiedAt);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ThreadEntityBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private BoardEntity board;
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private XrefUserTeamEntity xrefUserTeam;
        @SuppressWarnings("all")
        
        private EventEntity event;

        @SuppressWarnings("all")
        
        ThreadEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public ThreadEntity.ThreadEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadEntity.ThreadEntityBuilder board(final BoardEntity board) {
            this.board = board;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadEntity.ThreadEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadEntity.ThreadEntityBuilder xrefUserTeam(final XrefUserTeamEntity xrefUserTeam) {
            this.xrefUserTeam = xrefUserTeam;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadEntity.ThreadEntityBuilder event(final EventEntity event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        
        public ThreadEntity build() {
            return new ThreadEntity(this.name, this.board, this.user, this.xrefUserTeam, this.event);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ThreadEntity.ThreadEntityBuilder(name=" + this.name + ", board=" + this.board + ", user=" + this.user + ", xrefUserTeam=" + this.xrefUserTeam + ", event=" + this.event + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ThreadEntity.ThreadEntityBuilder builder() {
        return new ThreadEntity.ThreadEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected ThreadEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    @SuppressWarnings("all")
    
    public BoardEntity getBoard() {
        return this.board;
    }

    @SuppressWarnings("all")
    
    public UserEntity getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    
    public XrefUserTeamEntity getXrefUserTeam() {
        return this.xrefUserTeam;
    }

    @SuppressWarnings("all")
    
    public EventEntity getEvent() {
        return this.event;
    }

    @SuppressWarnings("all")
    
    public List<XrefThreadTagEntity> getXrefTags() {
        return this.xrefTags;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setModifiedAt(final OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @SuppressWarnings("all")
    
    public void setBoard(final BoardEntity board) {
        this.board = board;
    }

    @SuppressWarnings("all")
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    
    public void setXrefUserTeam(final XrefUserTeamEntity xrefUserTeam) {
        this.xrefUserTeam = xrefUserTeam;
    }

    @SuppressWarnings("all")
    
    public void setEvent(final EventEntity event) {
        this.event = event;
    }

    @SuppressWarnings("all")
    
    public void setXrefTags(final List<XrefThreadTagEntity> xrefTags) {
        this.xrefTags = xrefTags;
    }
    //</editor-fold>
}
