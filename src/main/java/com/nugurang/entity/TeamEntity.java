package com.nugurang.entity;

import com.nugurang.dto.TeamDto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class TeamEntity implements BaseEntity<TeamDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<ProjectEntity> projects = new ArrayList<>();
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<XrefUserTeamEntity> xrefUsers = new ArrayList<>();

    public TeamEntity(String name) {
        this.name = name;
    }

    @Override
    public TeamDto toDto() {
        return new TeamDto(id, name);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class TeamEntityBuilder {
        @SuppressWarnings("all")
        private String name;

        @SuppressWarnings("all")
        TeamEntityBuilder() {
        }

        @SuppressWarnings("all")
        public TeamEntity.TeamEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        public TeamEntity build() {
            return new TeamEntity(this.name);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "TeamEntity.TeamEntityBuilder(name=" + this.name + ")";
        }
    }

    @SuppressWarnings("all")
    public static TeamEntity.TeamEntityBuilder builder() {
        return new TeamEntity.TeamEntityBuilder();
    }

    @SuppressWarnings("all")
    protected TeamEntity() {
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
    public List<ProjectEntity> getProjects() {
        return this.projects;
    }

    @SuppressWarnings("all")
    public List<XrefUserTeamEntity> getXrefUsers() {
        return this.xrefUsers;
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
    public void setProjects(final List<ProjectEntity> projects) {
        this.projects = projects;
    }

    @SuppressWarnings("all")
    public void setXrefUsers(final List<XrefUserTeamEntity> xrefUsers) {
        this.xrefUsers = xrefUsers;
    }
    //</editor-fold>
}
