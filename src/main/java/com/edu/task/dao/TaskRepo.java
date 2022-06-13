package com.edu.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.task.model.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{
    
}
