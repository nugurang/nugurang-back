package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_event_tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"event", "tag"})})
public class XrefEventTagEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    private EventEntity event;
    @ManyToOne
    @JoinColumn(name = "tag", nullable = false)
    private TagEntity tag;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class XrefEventTagEntityBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private EventEntity event;
        @SuppressWarnings("all")
        
        private TagEntity tag;

        @SuppressWarnings("all")
        
        XrefEventTagEntityBuilder() {
        }

        @SuppressWarnings("all")
        
        public XrefEventTagEntity.XrefEventTagEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefEventTagEntity.XrefEventTagEntityBuilder event(final EventEntity event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefEventTagEntity.XrefEventTagEntityBuilder tag(final TagEntity tag) {
            this.tag = tag;
            return this;
        }

        @SuppressWarnings("all")
        
        public XrefEventTagEntity build() {
            return new XrefEventTagEntity(this.id, this.event, this.tag);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "XrefEventTagEntity.XrefEventTagEntityBuilder(id=" + this.id + ", event=" + this.event + ", tag=" + this.tag + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static XrefEventTagEntity.XrefEventTagEntityBuilder builder() {
        return new XrefEventTagEntity.XrefEventTagEntityBuilder();
    }

    @SuppressWarnings("all")
    
    public XrefEventTagEntity(final Long id, final EventEntity event, final TagEntity tag) {
        this.id = id;
        this.event = event;
        this.tag = tag;
    }

    @SuppressWarnings("all")
    
    protected XrefEventTagEntity() {
    }

    @SuppressWarnings("all")
    
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    
    public EventEntity getEvent() {
        return this.event;
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
    
    public void setEvent(final EventEntity event) {
        this.event = event;
    }

    @SuppressWarnings("all")
    
    public void setTag(final TagEntity tag) {
        this.tag = tag;
    }
    //</editor-fold>
}
