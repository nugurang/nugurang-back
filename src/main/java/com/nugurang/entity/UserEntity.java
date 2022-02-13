package com.nugurang.entity;

import com.nugurang.dto.UserDto;
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
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"oauth2_provider", "oauth2_id"})})
public class UserEntity implements BaseEntity<UserDto> {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "oauth2_provider", nullable = false)
    private String oauth2Provider;
    @Column(name = "oauth2_id", nullable = false)
    private String oauth2Id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String biography;
    @OneToOne
    @JoinColumn(name = "blog")
    private BoardEntity blog;
    @ManyToOne
    @JoinColumn(name = "image")
    private ImageEntity image;

    @Override
    public UserDto toDto() {
        return new UserDto(id, oauth2Provider, oauth2Id, name, email, biography);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class UserEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String oauth2Provider;
        @SuppressWarnings("all")
        
        private String oauth2Id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private String email;
        @SuppressWarnings("all")
        
        private String biography;
        @SuppressWarnings("all")
        
        private BoardEntity blog;
        @SuppressWarnings("all")
        
        private ImageEntity image;

        @SuppressWarnings("all")
        
        UserEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder oauth2Provider(final String oauth2Provider) {
            this.oauth2Provider = oauth2Provider;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder oauth2Id(final String oauth2Id) {
            this.oauth2Id = oauth2Id;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder email(final String email) {
            this.email = email;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder biography(final String biography) {
            this.biography = biography;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder blog(final BoardEntity blog) {
            this.blog = blog;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity.UserEntityBuilder image(final ImageEntity image) {
            this.image = image;
            return this;
        }

        @SuppressWarnings("all")
        
        public UserEntity build() {
            return new UserEntity(this.id, this.oauth2Provider, this.oauth2Id, this.name, this.email, this.biography, this.blog, this.image);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "UserEntity.UserEntityBuilder(id=" + this.id + ", oauth2Provider=" + this.oauth2Provider + ", oauth2Id=" + this.oauth2Id + ", name=" + this.name + ", email=" + this.email + ", biography=" + this.biography + ", blog=" + this.blog + ", image=" + this.image + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static UserEntity.UserEntityBuilder builder() {
        return new UserEntity.UserEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public UserEntity(final Long id, final String oauth2Provider, final String oauth2Id, final String name, final String email, final String biography, final BoardEntity blog, final ImageEntity image) {
        this.id = id;
        this.oauth2Provider = oauth2Provider;
        this.oauth2Id = oauth2Id;
        this.name = name;
        this.email = email;
        this.biography = biography;
        this.blog = blog;
        this.image = image;
    }

    @SuppressWarnings("all")
    
    protected UserEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public String getOauth2Provider() {
        return this.oauth2Provider;
    }

    @SuppressWarnings("all")
    
    public String getOauth2Id() {
        return this.oauth2Id;
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public String getEmail() {
        return this.email;
    }

    @SuppressWarnings("all")
    
    public String getBiography() {
        return this.biography;
    }

    @SuppressWarnings("all")
    
    public BoardEntity getBlog() {
        return this.blog;
    }

    @SuppressWarnings("all")
    
    public ImageEntity getImage() {
        return this.image;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setOauth2Provider(final String oauth2Provider) {
        this.oauth2Provider = oauth2Provider;
    }

    @SuppressWarnings("all")
    
    public void setOauth2Id(final String oauth2Id) {
        this.oauth2Id = oauth2Id;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setEmail(final String email) {
        this.email = email;
    }

    @SuppressWarnings("all")
    
    public void setBiography(final String biography) {
        this.biography = biography;
    }

    @SuppressWarnings("all")
    
    public void setBlog(final BoardEntity blog) {
        this.blog = blog;
    }

    @SuppressWarnings("all")
    
    public void setImage(final ImageEntity image) {
        this.image = image;
    }
    //</editor-fold>
}
