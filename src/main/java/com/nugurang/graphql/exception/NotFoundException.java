package com.nugurang.graphql.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

public class NotFoundException extends RuntimeException implements GraphQLError {
    @NonNull
    private String objectName;

    public NotFoundException(@NonNull String message, String objectName) {
        super(message);
        //<editor-fold defaultstate="collapsed" desc="delombok">
        if (message == null) {
            throw new NullPointerException("message is marked non-null but is null");
        }
        //</editor-fold>
        this.objectName = objectName;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("object", objectName);
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class NotFoundExceptionBuilder {
        @SuppressWarnings("all")
        
        private String message;
        @SuppressWarnings("all")
        
        private String objectName;

        @SuppressWarnings("all")
        
        NotFoundExceptionBuilder() {
        }

        @SuppressWarnings("all")
        
        public NotFoundException.NotFoundExceptionBuilder message(@NonNull final String message) {
            if (message == null) {
                throw new NullPointerException("message is marked non-null but is null");
            }
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
    }

    @SuppressWarnings("all")
    
    public static NotFoundException.NotFoundExceptionBuilder builder() {
        return new NotFoundException.NotFoundExceptionBuilder();
    }
    //</editor-fold>
}
