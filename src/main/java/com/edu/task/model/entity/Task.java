package com.edu.task.model.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Long id;

    @NotNull
    @Column(name = "TITLE", length = 60)
    private String title;

    @NotNull
    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @NotNull
    @Column(name = "STATUS", length = 40)
    private String status;

    @Column(name = "PRIORITY", length = 40)
    private String priority;

    @NotNull
    @Column(name = "CREATED_AT", updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private OffsetDateTime updatedAt;

}