package com.edu.task.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class InputTaskDto {
    
    @NotNull
    @Size(min = 1, max = 60)
    private String title;

    @Size(min = 1, max = 2000)
    private String description;

    @NotNull
    @Pattern(regexp = "to do|in progress|done")
    private String status;

    @NotNull
    @Pattern(regexp = "low|medium|high")
    private String priority;
    
}
