package com.edu.task.model.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class TaskDto {
    
    private Long id;

    private String title;

    private String description;

    private String status;

    private String priority;
    
    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
