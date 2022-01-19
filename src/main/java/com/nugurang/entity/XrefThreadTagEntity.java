package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_thread_tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"thread", "tag"})})
public class XrefThreadTagEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "thread", nullable = false)
    private ThreadEntity thread;
    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private TagEntity tag;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class XrefThreadTagEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private ThreadEntity thread;
        @SuppressWarnings("all")
        
        private TagEntity tag;

        @SuppressWarnings("all")
        
        XrefThreadTagEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public XrefThreadTagEntity.XrefThreadTagEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefThreadTagEntity.XrefThreadTagEntityBuilder thread(final ThreadEntity thread) {
            this.thread = thread;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefThreadTagEntity.XrefThreadTagEntityBuilder tag(final TagEntity tag) {
            this.tag = tag;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefThreadTagEntity build() {
            return new XrefThreadTagEntity(this.id, this.thread, this.tag);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "XrefThreadTagEntity.XrefThreadTagEntityBuilder(id=" + this.id + ", thread=" + this.thread + ", tag=" + this.tag + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static XrefThreadTagEntity.XrefThreadTagEntityBuilder builder() {
        return new XrefThreadTagEntity.XrefThreadTagEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public XrefThreadTagEntity(final Long id, final ThreadEntity thread, final TagEntity tag) {
        this.id = id;
        this.thread = thread;
        this.tag = tag;
    }

    @SuppressWarnings("all")
    
    protected XrefThreadTagEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public ThreadEntity getThread() {
        return this.thread;
    }

    @SuppressWarnings("all")
    
    public TagEntity getTag() {
        return this.tag;
    }

    @SuppressWarnings("all")
    
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    
    public void setThread(final ThreadEntity thread) {
        this.thread = thread;
    }

    @SuppressWarnings("all")
    
    public void setTag(final TagEntity tag) {
        this.tag = tag;
    }
    //</editor-fold>
}
