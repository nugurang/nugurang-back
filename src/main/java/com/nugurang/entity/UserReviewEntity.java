package com.nugurang.entity;

import com.nugurang.dto.UserReviewDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_review", uniqueConstraints = {@UniqueConstraint(columnNames = {"position", "from_user", "to_user", "user_evaluation"})})
public class UserReviewEntity implements BaseEntity<UserReviewDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Integer honor;
    @ManyToOne
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;
    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    private UserEntity fromUser;
    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    private UserEntity toUser;
    @ManyToOne
    @JoinColumn(name = "user_evaluation", nullable = false)
    private UserEvaluationEntity userEvaluation;

    public UserReviewDto toDto() {
        return new UserReviewDto(id, honor);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserReviewEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private Integer honor;
        @SuppressWarnings("all")
        
        private PositionEntity position;
        @SuppressWarnings("all")
        
        private UserEntity fromUser;
        @SuppressWarnings("all")
        
        private UserEntity toUser;
        @SuppressWarnings("all")
        
        private UserEvaluationEntity userEvaluation;

        @SuppressWarnings("all")
        
        UserReviewEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserReviewEntity.UserReviewEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewEntity.UserReviewEntityBuilder honor(final Integer honor) {
            this.honor = honor;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewEntity.UserReviewEntityBuilder position(final PositionEntity position) {
            this.position = position;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewEntity.UserReviewEntityBuilder fromUser(final UserEntity fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewEntity.UserReviewEntityBuilder toUser(final UserEntity toUser) {
            this.toUser = toUser;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewEntity.UserReviewEntityBuilder userEvaluation(final UserEvaluationEntity userEvaluation) {
            this.userEvaluation = userEvaluation;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserReviewEntity build() {
            return new UserReviewEntity(this.id, this.honor, this.position, this.fromUser, this.toUser, this.userEvaluation);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserReviewEntity.UserReviewEntityBuilder(id=" + this.id + ", honor=" + this.honor + ", position=" + this.position + ", fromUser=" + this.fromUser + ", toUser=" + this.toUser + ", userEvaluation=" + this.userEvaluation + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserReviewEntity.UserReviewEntityBuilder builder() {
        return new UserReviewEntity.UserReviewEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected UserReviewEntity() {
    }

    @SuppressWarnings("all")
    
    public UserReviewEntity(final Long id, final Integer honor, final PositionEntity position, final UserEntity fromUser, final UserEntity toUser, final UserEvaluationEntity userEvaluation) {
        this.id = id;
        this.honor = honor;
        this.position = position;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.userEvaluation = userEvaluation;
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
    
    public PositionEntity getPosition() {
        return this.position;
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
    
    public UserEvaluationEntity getUserEvaluation() {
        return this.userEvaluation;
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
    
    public void setPosition(final PositionEntity position) {
        this.position = position;
    }

    @SuppressWarnings("all")
    
    public void setFromUser(final UserEntity fromUser) {
        this.fromUser = fromUser;
    }

    @SuppressWarnings("all")
    
    public void setToUser(final UserEntity toUser) {
        this.toUser = toUser;
    }

    @SuppressWarnings("all")
    
    public void setUserEvaluation(final UserEvaluationEntity userEvaluation) {
        this.userEvaluation = userEvaluation;
    }
    //</editor-fold>
}
