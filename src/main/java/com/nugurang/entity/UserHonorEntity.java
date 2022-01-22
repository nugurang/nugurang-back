package com.nugurang.entity;

import com.nugurang.dto.UserHonorDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_honor", uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "position"})})
public class UserHonorEntity implements BaseEntity<UserHonorDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Integer honor;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;

    public UserHonorEntity(Integer honor, UserEntity user, PositionEntity position) {
        this.honor = honor;
        this.user = user;
        this.position = position;
    }

    public UserHonorDto toDto() {
        return new UserHonorDto(id, honor);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserHonorEntityBuilder {
        @SuppressWarnings("all")
        
        private Integer honor;
        @SuppressWarnings("all")
        
        private UserEntity user;
        @SuppressWarnings("all")
        
        private PositionEntity position;

        @SuppressWarnings("all")
        
        UserHonorEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserHonorEntity.UserHonorEntityBuilder honor(final Integer honor) {
            this.honor = honor;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserHonorEntity.UserHonorEntityBuilder user(final UserEntity user) {
            this.user = user;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserHonorEntity.UserHonorEntityBuilder position(final PositionEntity position) {
            this.position = position;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserHonorEntity build() {
            return new UserHonorEntity(this.honor, this.user, this.position);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserHonorEntity.UserHonorEntityBuilder(honor=" + this.honor + ", user=" + this.user + ", position=" + this.position + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserHonorEntity.UserHonorEntityBuilder builder() {
        return new UserHonorEntity.UserHonorEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected UserHonorEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public Integer getHonor() {
        return this.honor;
    }

    @SuppressWarnings("all")
    
    public UserEntity getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    
    public PositionEntity getPosition() {
        return this.position;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setHonor(final Integer honor) {
        this.honor = honor;
    }

    @SuppressWarnings("all")
    
    public void setUser(final UserEntity user) {
        this.user = user;
    }

    @SuppressWarnings("all")
    
    public void setPosition(final PositionEntity position) {
        this.position = position;
    }
    //</editor-fold>
}
