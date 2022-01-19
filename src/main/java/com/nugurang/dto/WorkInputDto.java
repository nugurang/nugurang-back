package com.nugurang.dto;

import java.util.Optional;
import javax.validation.constraints.NotNull;

public class WorkInputDto {
    @NotNull
    private String name;
    @NotNull
    private Optional<Integer> order;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class WorkInputDtoBuilder {
        @SuppressWarnings("all")
        
        private String name;
        @SuppressWarnings("all")
        
        private Optional<Integer> order;

        @SuppressWarnings("all")
        
        WorkInputDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public WorkInputDto.WorkInputDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkInputDto.WorkInputDtoBuilder order(final Optional<Integer> order) {
            this.order = order;
            return this;
        }

        @SuppressWarnings("all")
        
        public WorkInputDto build() {
            return new WorkInputDto(this.name, this.order);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "WorkInputDto.WorkInputDtoBuilder(name=" + this.name + ", order=" + this.order + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static WorkInputDto.WorkInputDtoBuilder builder() {
        return new WorkInputDto.WorkInputDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    
    public Optional<Integer> getOrder() {
        return this.order;
    }

    @SuppressWarnings("all")
    
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    
    public void setOrder(final Optional<Integer> order) {
        this.order = order;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WorkInputDto)) return false;
        final WorkInputDto other = (WorkInputDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$order = this.getOrder();
        final Object other$order = other.getOrder();
        if (this$order == null ? other$order != null : !this$order.equals(other$order)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof WorkInputDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $order = this.getOrder();
        result = result * PRIME + ($order == null ? 43 : $order.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "WorkInputDto(name=" + this.getName() + ", order=" + this.getOrder() + ")";
    }

    @SuppressWarnings("all")
    
    public WorkInputDto(final String name, final Optional<Integer> order) {
        this.name = name;
        this.order = order;
    }
    //</editor-fold>
}
