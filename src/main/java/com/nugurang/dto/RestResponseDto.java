package com.nugurang.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseDto {
    private Optional<Object> data;
    private Optional<List<Error>> errors;
    private Optional<Object> extensions;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Error {
        private String message;
        private List<Location> locations;
        private List<String> path;
        private Optional<Object> extensions;


        public static class Location {
            private Long line;
            private Long column;


            //<editor-fold defaultstate="collapsed" desc="delombok">
            @SuppressWarnings("all")
            
            public static class LocationBuilder {
                @SuppressWarnings("all")
                
                private Long line;
                @SuppressWarnings("all")
                
                private Long column;

                @SuppressWarnings("all")
                
                LocationBuilder() {
                }

                @SuppressWarnings("all")
                
                public RestResponseDto.Error.Location.LocationBuilder line(final Long line) {
                    this.line = line;
                    return this;
                }

                @SuppressWarnings("all")
                
                public RestResponseDto.Error.Location.LocationBuilder column(final Long column) {
                    this.column = column;
                    return this;
                }

                @SuppressWarnings("all")
                
                public RestResponseDto.Error.Location build() {
                    return new RestResponseDto.Error.Location(this.line, this.column);
                }

                @Override
                @SuppressWarnings("all")
                
                public String toString() {
                    return "RestResponseDto.Error.Location.LocationBuilder(line=" + this.line + ", column=" + this.column + ")";
                }
            }

            @SuppressWarnings("all")
            
            public static RestResponseDto.Error.Location.LocationBuilder builder() {
                return new RestResponseDto.Error.Location.LocationBuilder();
            }

            @SuppressWarnings("all")
            
            public Long getLine() {
                return this.line;
            }

            @SuppressWarnings("all")
            
            public Long getColumn() {
                return this.column;
            }

            @SuppressWarnings("all")
            
            public void setLine(final Long line) {
                this.line = line;
            }

            @SuppressWarnings("all")
            
            public void setColumn(final Long column) {
                this.column = column;
            }

            @Override
            @SuppressWarnings("all")
            
            public boolean equals(final Object o) {
                if (o == this) return true;
                if (!(o instanceof RestResponseDto.Error.Location)) return false;
                final RestResponseDto.Error.Location other = (RestResponseDto.Error.Location) o;
                if (!other.canEqual((Object) this)) return false;
                final Object this$line = this.getLine();
                final Object other$line = other.getLine();
                if (this$line == null ? other$line != null : !this$line.equals(other$line)) return false;
                final Object this$column = this.getColumn();
                final Object other$column = other.getColumn();
                if (this$column == null ? other$column != null : !this$column.equals(other$column)) return false;
                return true;
            }

            @SuppressWarnings("all")
            
            protected boolean canEqual(final Object other) {
                return other instanceof RestResponseDto.Error.Location;
            }

            @Override
            @SuppressWarnings("all")
            
            public int hashCode() {
                final int PRIME = 59;
                int result = 1;
                final Object $line = this.getLine();
                result = result * PRIME + ($line == null ? 43 : $line.hashCode());
                final Object $column = this.getColumn();
                result = result * PRIME + ($column == null ? 43 : $column.hashCode());
                return result;
            }

            @Override
            @SuppressWarnings("all")
            
            public String toString() {
                return "RestResponseDto.Error.Location(line=" + this.getLine() + ", column=" + this.getColumn() + ")";
            }

            @SuppressWarnings("all")
            
            public Location(final Long line, final Long column) {
                this.line = line;
                this.column = column;
            }
            //</editor-fold>
        }


        public static class ErrorExtension {
            private String type;


            //<editor-fold defaultstate="collapsed" desc="delombok">
            @SuppressWarnings("all")
            
            public static class ErrorExtensionBuilder {
                @SuppressWarnings("all")
                
                private String type;

                @SuppressWarnings("all")
                
                ErrorExtensionBuilder() {
                }

                @SuppressWarnings("all")
                
                public RestResponseDto.Error.ErrorExtension.ErrorExtensionBuilder type(final String type) {
                    this.type = type;
                    return this;
                }

                @SuppressWarnings("all")
                
                public RestResponseDto.Error.ErrorExtension build() {
                    return new RestResponseDto.Error.ErrorExtension(this.type);
                }

                @Override
                @SuppressWarnings("all")
                
                public String toString() {
                    return "RestResponseDto.Error.ErrorExtension.ErrorExtensionBuilder(type=" + this.type + ")";
                }
            }

            @SuppressWarnings("all")
            
            public static RestResponseDto.Error.ErrorExtension.ErrorExtensionBuilder builder() {
                return new RestResponseDto.Error.ErrorExtension.ErrorExtensionBuilder();
            }

            @SuppressWarnings("all")
            
            public String getType() {
                return this.type;
            }

            @SuppressWarnings("all")
            
            public void setType(final String type) {
                this.type = type;
            }

            @Override
            @SuppressWarnings("all")
            
            public boolean equals(final Object o) {
                if (o == this) return true;
                if (!(o instanceof RestResponseDto.Error.ErrorExtension)) return false;
                final RestResponseDto.Error.ErrorExtension other = (RestResponseDto.Error.ErrorExtension) o;
                if (!other.canEqual((Object) this)) return false;
                final Object this$type = this.getType();
                final Object other$type = other.getType();
                if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
                return true;
            }

            @SuppressWarnings("all")
            
            protected boolean canEqual(final Object other) {
                return other instanceof RestResponseDto.Error.ErrorExtension;
            }

            @Override
            @SuppressWarnings("all")
            
            public int hashCode() {
                final int PRIME = 59;
                int result = 1;
                final Object $type = this.getType();
                result = result * PRIME + ($type == null ? 43 : $type.hashCode());
                return result;
            }

            @Override
            @SuppressWarnings("all")
            
            public String toString() {
                return "RestResponseDto.Error.ErrorExtension(type=" + this.getType() + ")";
            }

            @SuppressWarnings("all")
            
            public ErrorExtension(final String type) {
                this.type = type;
            }
            //</editor-fold>
        }


        //<editor-fold defaultstate="collapsed" desc="delombok">
        @SuppressWarnings("all")
        
        public static class ErrorBuilder {
            @SuppressWarnings("all")
            
            private String message;
            @SuppressWarnings("all")
            
            private List<Location> locations;
            @SuppressWarnings("all")
            
            private List<String> path;
            @SuppressWarnings("all")
            
            private Optional<Object> extensions;

            @SuppressWarnings("all")
            
            ErrorBuilder() {
            }

            @SuppressWarnings("all")
            
            public RestResponseDto.Error.ErrorBuilder message(final String message) {
                this.message = message;
                return this;
            }

            @SuppressWarnings("all")
            
            public RestResponseDto.Error.ErrorBuilder locations(final List<Location> locations) {
                this.locations = locations;
                return this;
            }

            @SuppressWarnings("all")
            
            public RestResponseDto.Error.ErrorBuilder path(final List<String> path) {
                this.path = path;
                return this;
            }

            @SuppressWarnings("all")
            
            public RestResponseDto.Error.ErrorBuilder extensions(final Optional<Object> extensions) {
                this.extensions = extensions;
                return this;
            }

            @SuppressWarnings("all")
            
            public RestResponseDto.Error build() {
                return new RestResponseDto.Error(this.message, this.locations, this.path, this.extensions);
            }

            @Override
            @SuppressWarnings("all")
            
            public String toString() {
                return "RestResponseDto.Error.ErrorBuilder(message=" + this.message + ", locations=" + this.locations + ", path=" + this.path + ", extensions=" + this.extensions + ")";
            }
        }

        @SuppressWarnings("all")
        
        public static RestResponseDto.Error.ErrorBuilder builder() {
            return new RestResponseDto.Error.ErrorBuilder();
        }

        @SuppressWarnings("all")
        
        public String getMessage() {
            return this.message;
        }

        @SuppressWarnings("all")
        
        public List<Location> getLocations() {
            return this.locations;
        }

        @SuppressWarnings("all")
        
        public List<String> getPath() {
            return this.path;
        }

        @SuppressWarnings("all")
        
        public Optional<Object> getExtensions() {
            return this.extensions;
        }

        @SuppressWarnings("all")
        
        public void setMessage(final String message) {
            this.message = message;
        }

        @SuppressWarnings("all")
        
        public void setLocations(final List<Location> locations) {
            this.locations = locations;
        }

        @SuppressWarnings("all")
        
        public void setPath(final List<String> path) {
            this.path = path;
        }

        @SuppressWarnings("all")
        
        public void setExtensions(final Optional<Object> extensions) {
            this.extensions = extensions;
        }

        @Override
        @SuppressWarnings("all")
        
        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof RestResponseDto.Error)) return false;
            final RestResponseDto.Error other = (RestResponseDto.Error) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$message = this.getMessage();
            final Object other$message = other.getMessage();
            if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
            final Object this$locations = this.getLocations();
            final Object other$locations = other.getLocations();
            if (this$locations == null ? other$locations != null : !this$locations.equals(other$locations)) return false;
            final Object this$path = this.getPath();
            final Object other$path = other.getPath();
            if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
            final Object this$extensions = this.getExtensions();
            final Object other$extensions = other.getExtensions();
            if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) return false;
            return true;
        }

        @SuppressWarnings("all")
        
        protected boolean canEqual(final Object other) {
            return other instanceof RestResponseDto.Error;
        }

        @Override
        @SuppressWarnings("all")
        
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $message = this.getMessage();
            result = result * PRIME + ($message == null ? 43 : $message.hashCode());
            final Object $locations = this.getLocations();
            result = result * PRIME + ($locations == null ? 43 : $locations.hashCode());
            final Object $path = this.getPath();
            result = result * PRIME + ($path == null ? 43 : $path.hashCode());
            final Object $extensions = this.getExtensions();
            result = result * PRIME + ($extensions == null ? 43 : $extensions.hashCode());
            return result;
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "RestResponseDto.Error(message=" + this.getMessage() + ", locations=" + this.getLocations() + ", path=" + this.getPath() + ", extensions=" + this.getExtensions() + ")";
        }

        @SuppressWarnings("all")
        
        public Error(final String message, final List<Location> locations, final List<String> path, final Optional<Object> extensions) {
            this.message = message;
            this.locations = locations;
            this.path = path;
            this.extensions = extensions;
        }
        //</editor-fold>
    }


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public static class RestResponseDtoBuilder {
        @SuppressWarnings("all")
        
        private Optional<Object> data;
        @SuppressWarnings("all")
        
        private Optional<List<Error>> errors;
        @SuppressWarnings("all")
        
        private Optional<Object> extensions;

        @SuppressWarnings("all")
        
        RestResponseDtoBuilder() {
        }

        @SuppressWarnings("all")
        
        public RestResponseDto.RestResponseDtoBuilder data(final Optional<Object> data) {
            this.data = data;
            return this;
        }

        @SuppressWarnings("all")
        
        public RestResponseDto.RestResponseDtoBuilder errors(final Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        @SuppressWarnings("all")
        
        public RestResponseDto.RestResponseDtoBuilder extensions(final Optional<Object> extensions) {
            this.extensions = extensions;
            return this;
        }

        @SuppressWarnings("all")
        
        public RestResponseDto build() {
            return new RestResponseDto(this.data, this.errors, this.extensions);
        }

        @Override
        @SuppressWarnings("all")
        
        public String toString() {
            return "RestResponseDto.RestResponseDtoBuilder(data=" + this.data + ", errors=" + this.errors + ", extensions=" + this.extensions + ")";
        }
    }

    @SuppressWarnings("all")
    
    public static RestResponseDto.RestResponseDtoBuilder builder() {
        return new RestResponseDto.RestResponseDtoBuilder();
    }

    @SuppressWarnings("all")
    
    public Optional<Object> getData() {
        return this.data;
    }

    @SuppressWarnings("all")
    
    public Optional<List<Error>> getErrors() {
        return this.errors;
    }

    @SuppressWarnings("all")
    
    public Optional<Object> getExtensions() {
        return this.extensions;
    }

    @SuppressWarnings("all")
    
    public void setData(final Optional<Object> data) {
        this.data = data;
    }

    @SuppressWarnings("all")
    
    public void setErrors(final Optional<List<Error>> errors) {
        this.errors = errors;
    }

    @SuppressWarnings("all")
    
    public void setExtensions(final Optional<Object> extensions) {
        this.extensions = extensions;
    }

    @Override
    @SuppressWarnings("all")
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RestResponseDto)) return false;
        final RestResponseDto other = (RestResponseDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        final Object this$errors = this.getErrors();
        final Object other$errors = other.getErrors();
        if (this$errors == null ? other$errors != null : !this$errors.equals(other$errors)) return false;
        final Object this$extensions = this.getExtensions();
        final Object other$extensions = other.getExtensions();
        if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) return false;
        return true;
    }

    @SuppressWarnings("all")
    
    protected boolean canEqual(final Object other) {
        return other instanceof RestResponseDto;
    }

    @Override
    @SuppressWarnings("all")
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        final Object $errors = this.getErrors();
        result = result * PRIME + ($errors == null ? 43 : $errors.hashCode());
        final Object $extensions = this.getExtensions();
        result = result * PRIME + ($extensions == null ? 43 : $extensions.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    
    public String toString() {
        return "RestResponseDto(data=" + this.getData() + ", errors=" + this.getErrors() + ", extensions=" + this.getExtensions() + ")";
    }

    @SuppressWarnings("all")
    
    public RestResponseDto(final Optional<Object> data, final Optional<List<Error>> errors, final Optional<Object> extensions) {
        this.data = data;
        this.errors = errors;
        this.extensions = extensions;
    }
    //</editor-fold>
}
