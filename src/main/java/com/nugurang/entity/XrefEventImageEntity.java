package com.nugurang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "xref_event_image", uniqueConstraints = {@UniqueConstraint(columnNames = {"event", "image"})})
public class XrefEventImageEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    private EventEntity event;
    @ManyToOne
    @JoinColumn(name = "image", nullable = false)
    private ImageEntity image;

    public XrefEventImageEntity(EventEntity event, ImageEntity image) {
        this.event = event;
        this.image = image;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class XrefEventImageEntityBuilder {
        @SuppressWarnings("all")
        private EventEntity event;
        @SuppressWarnings("all")
        private ImageEntity image;

        @SuppressWarnings("all")
        XrefEventImageEntityBuilder() {
        }

        @SuppressWarnings("all")
        public XrefEventImageEntity.XrefEventImageEntityBuilder event(final EventEntity event) {
            this.event = event;
            return this;
        }

        @SuppressWarnings("all")
        public XrefEventImageEntity.XrefEventImageEntityBuilder image(final ImageEntity image) {
            this.image = image;
            return this;
        }

        @SuppressWarnings("all")
        public XrefEventImageEntity build() {
            return new XrefEventImageEntity(this.event, this.image);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "XrefEventImageEntity.XrefEventImageEntityBuilder(event=" + this.event + ", image=" + this.image + ")";
        }
    }

    @SuppressWarnings("all")
    public static XrefEventImageEntity.XrefEventImageEntityBuilder builder() {
        return new XrefEventImageEntity.XrefEventImageEntityBuilder();
    }

    @SuppressWarnings("all")
    protected XrefEventImageEntity() {
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
    public ImageEntity getImage() {
        return this.image;
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
    public void setImage(final ImageEntity image) {
        this.image = image;
    }
    //</editor-fold>
}
