package com.nugurang.entity;

import com.nugurang.dto.UserEvaluationDto;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "user_evaluation")
public class UserEvaluationEntity implements BaseEntity<UserEvaluationDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime expiredAt;
    @OneToOne(mappedBy = "userEvaluation")
    private ProjectEntity project;

    @PreRemove
    private void preRemove() {
        if (project != null) project.setUserEvaluation(null);
    }

    public UserEvaluationDto toDto() {
        return UserEvaluationDto.builder().id(id).createdAt(createdAt).expiredAt(expiredAt).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserEvaluationEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private OffsetDateTime createdAt;
        @SuppressWarnings("all")
        
        private OffsetDateTime expiredAt;
        @SuppressWarnings("all")
        
        private ProjectEntity project;

        @SuppressWarnings("all")
        
        UserEvaluationEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserEvaluationEntity.UserEvaluationEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEvaluationEntity.UserEvaluationEntityBuilder createdAt(final OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEvaluationEntity.UserEvaluationEntityBuilder expiredAt(final OffsetDateTime expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEvaluationEntity.UserEvaluationEntityBuilder project(final ProjectEntity project) {
            this.project = project;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEvaluationEntity build() {
            return new UserEvaluationEntity(this.id, this.createdAt, this.expiredAt, this.project);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserEvaluationEntity.UserEvaluationEntityBuilder(id=" + this.id + ", createdAt=" + this.createdAt + ", expiredAt=" + this.expiredAt + ", project=" + this.project + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserEvaluationEntity.UserEvaluationEntityBuilder builder() {
        return new UserEvaluationEntity.UserEvaluationEntityBuilder();
    }

    @SuppressWarnings("all")
    
    protected UserEvaluationEntity() {
    }

    @SuppressWarnings("all")
    
    public UserEvaluationEntity(final Long id, final OffsetDateTime createdAt, final OffsetDateTime expiredAt, final ProjectEntity project) {
        this.id = id;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.project = project;
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    @SuppressWarnings("all")
    
    public OffsetDateTime getExpiredAt() {
        return this.expiredAt;
    }

    @SuppressWarnings("all")
    
    public ProjectEntity getProject() {
        return this.project;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("all")
    
    public void setExpiredAt(final OffsetDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    @SuppressWarnings("all")
    
    public void setProject(final ProjectEntity project) {
        this.project = project;
    }
    //</editor-fold>
}
