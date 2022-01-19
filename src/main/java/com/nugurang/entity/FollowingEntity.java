package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "following", uniqueConstraints = {@UniqueConstraint(columnNames = {"from_user", "to_user"})})
public class FollowingEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    private UserEntity fromUser;
    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    private UserEntity toUser;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class FollowingEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private UserEntity fromUser;
        @SuppressWarnings("all")
        
        private UserEntity toUser;

        @SuppressWarnings("all")
        
        FollowingEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public FollowingEntity.FollowingEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public FollowingEntity.FollowingEntityBuilder fromUser(final UserEntity fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public FollowingEntity.FollowingEntityBuilder toUser(final UserEntity toUser) {
            this.toUser = toUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public FollowingEntity build() {
            return new FollowingEntity(this.id, this.fromUser, this.toUser);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "FollowingEntity.FollowingEntityBuilder(id=" + this.id + ", fromUser=" + this.fromUser + ", toUser=" + this.toUser + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static FollowingEntity.FollowingEntityBuilder builder() {
        return new FollowingEntity.FollowingEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public FollowingEntity(final Long id, final UserEntity fromUser, final UserEntity toUser) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    @SuppressWarnings("all")
    
    protected FollowingEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public UserEntity getFromUser() {
        return this.fromUser;
    }

    @SuppressWarnings("all")
    
    public UserEntity getToUser() {
        return this.toUser;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setFromUser(final UserEntity fromUser) {
        this.fromUser = fromUser;
    }

    @SuppressWarnings("all")
    
    public void setToUser(final UserEntity toUser) {
        this.toUser = toUser;
    }
    //</editor-fold>
}
