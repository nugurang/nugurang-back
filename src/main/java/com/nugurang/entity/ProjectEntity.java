package com.nugurang.entity;

import com.nugurang.dto.ProjectDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "project", uniqueConstraints = @UniqueConstraint(columnNames = {"team", "name"}))
public class ProjectEntity implements BaseEntity<ProjectDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean finished;
    @ManyToOne
    @JoinColumn(name = "team", nullable = false)
    private TeamEntity team;
    @ManyToOne
    @JoinColumn(name = "event")
    private EventEntity event;
    @OneToOne
    @JoinColumn(name = "user_evaluation", unique = true)
    private UserEvaluationEntity userEvaluation;

    @Override
    public ProjectDto toDto() {
        return ProjectDto.builder().id(id).name(name).finished(finished).build();
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class ProjectEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Boolean finished;
        @SuppressWarnings("all")
        
        private TeamEntity team;
        @SuppressWarnings("all")
        
        private EventEntity event;
        @SuppressWarnings("all")
        
        private UserEvaluationEntity userEvaluation;

        @SuppressWarnings("all")
        
        ProjectEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public ProjectEntity.ProjectEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectEntity.ProjectEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectEntity.ProjectEntityBuilder finished(final Boolean finished) {
            this.finished = finished;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectEntity.ProjectEntityBuilder team(final TeamEntity team) {
            this.team = team;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectEntity.ProjectEntityBuilder event(final EventEntity event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectEntity.ProjectEntityBuilder userEvaluation(final UserEvaluationEntity userEvaluation) {
            this.userEvaluation = userEvaluation;
            return this;
        }

        @SuppressWarnings("all")
        
        public ProjectEntity build() {
            return new ProjectEntity(this.id, this.name, this.finished, this.team, this.event, this.userEvaluation);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "ProjectEntity.ProjectEntityBuilder(id=" + this.id + ", name=" + this.name + ", finished=" + this.finished + ", team=" + this.team + ", event=" + this.event + ", userEvaluation=" + this.userEvaluation + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static ProjectEntity.ProjectEntityBuilder builder() {
        return new ProjectEntity.ProjectEntityBuilder();
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
    
    public Boolean getFinished() {
        return this.finished;
    }

    @SuppressWarnings("all")
    
    public TeamEntity getTeam() {
        return this.team;
    }

    @SuppressWarnings("all")
    
    public EventEntity getEvent() {
        return this.event;
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
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setFinished(final Boolean finished) {
        this.finished = finished;
    }

    @SuppressWarnings("all")
    
    public void setTeam(final TeamEntity team) {
        this.team = team;
    }

    @SuppressWarnings("all")
    
    public void setEvent(final EventEntity event) {
        this.event = event;
    }

    @SuppressWarnings("all")
    
    public void setUserEvaluation(final UserEvaluationEntity userEvaluation) {
        this.userEvaluation = userEvaluation;
    }

    @SuppressWarnings("all")
    
    public ProjectEntity(final Long id, final String name, final Boolean finished, final TeamEntity team, final EventEntity event, final UserEvaluationEntity userEvaluation) {
        this.id = id;
        this.name = name;
        this.finished = finished;
        this.team = team;
        this.event = event;
        this.userEvaluation = userEvaluation;
    }

    @SuppressWarnings("all")
    
    protected ProjectEntity() {
    }
    //</editor-fold>
}
