package com.nugurang.dto;

import javax.validation.constraints.NotNull;

public class WorkDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer order;
    @NotNull
    private Boolean opened;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class WorkDtoBuilder {
        @SuppressWarnings("all")
        
        private Long id;
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Integer order;
        @SuppressWarnings("all")
        
        private Boolean opened;

        @SuppressWarnings("all")
        
        WorkDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public WorkDto.WorkDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkDto.WorkDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkDto.WorkDtoBuilder order(final Integer order) {
            this.order = order;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkDto.WorkDtoBuilder opened(final Boolean opened) {
            this.opened = opened;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkDto build() {
            return new WorkDto(this.id, this.name, this.order, this.opened);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "WorkDto.WorkDtoBuilder(id=" + this.id + ", name=" + this.name + ", order=" + this.order + ", opened=" + this.opened + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static WorkDto.WorkDtoBuilder builder() {
        return new WorkDto.WorkDtoBuilder();
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
    
    public Integer getOrder() {
        return this.order;
    }

    @SuppressWarnings("all")
    
    public Boolean getOpened() {
        return this.opened;
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
    
    public void setOrder(final Integer order) {
        this.order = order;
    }

    @SuppressWarnings("all")
    
    public void setOpened(final Boolean opened) {
        this.opened = opened;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WorkDto)) return false;
        final WorkDto other = (WorkDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$order = this.getOrder();
        final Object other$order = other.getOrder();
        if (this$order == null ? other$order != null : !this$order.equals(other$order)) return false;
        final Object this$opened = this.getOpened();
        final Object other$opened = other.getOpened();
        if (this$opened == null ? other$opened != null : !this$opened.equals(other$opened)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof WorkDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $order = this.getOrder();
        result = result * PRIME + ($order == null ? 43 : $order.hashCode());
        final Object $opened = this.getOpened();
        result = result * PRIME + ($opened == null ? 43 : $opened.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "WorkDto(id=" + this.getId() + ", name=" + this.getName() + ", order=" + this.getOrder() + ", opened=" + this.getOpened() + ")";
    }

    @SuppressWarnings("all")
    
    public WorkDto(final Long id, final String name, final Integer order, final Boolean opened) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.opened = opened;
    }
    //</editor-fold>
}
