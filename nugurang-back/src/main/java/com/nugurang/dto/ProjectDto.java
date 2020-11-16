package com.nugurang.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProjectDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Boolean finished;
}
