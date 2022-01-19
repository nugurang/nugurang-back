package com.nugurang.exception;

import lombok.NonNull;

public class NotFoundException extends Exception {
    @NonNull
    private String objectName;

    public NotFoundException(String message, String objectName) {
        super(message);
        this.objectName = objectName;
    }

    public NotFoundException(String message, Throwable cause, String objectName) {
        super(message, cause);
        this.objectName = objectName;
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class NotFoundExceptionBuilder {
        @SuppressWarnings("all")
        
        private String message;
        @SuppressWarnings("all")
        
        private String objectName;
        @SuppressWarnings("all")
        
        private Throwable cause;

        @SuppressWarnings("all")
        
        NotFoundExceptionBuilder() {
        }

        @SuppressWarnings("all")
        
        public NotFoundException.NotFoundExceptionBuilder message(final String message) {
            this.message = message;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotFoundException.NotFoundExceptionBuilder objectName(final String objectName) {
            this.objectName = objectName;
            return this;
        }

        @SuppressWarnings("all")
        
        public NotFoundException build() {
            return new NotFoundException(this.message, this.objectName);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "NotFoundException.NotFoundExceptionBuilder(message=" + this.message + ", objectName=" + this.objectName + ")";
        }

        @SuppressWarnings("all")
        
        public NotFoundException.NotFoundExceptionBuilder cause(final Throwable cause) {
            this.cause = cause;
            return this;
        }
    }

    @SuppressWarnings("all")
    
    public static NotFoundException.NotFoundExceptionBuilder builder() {
        return new NotFoundException.NotFoundExceptionBuilder();
    }

    @NonNull
    @SuppressWarnings("all")
    
    public String getObjectName() {
        return this.objectName;
    }
    //</editor-fold>
}
