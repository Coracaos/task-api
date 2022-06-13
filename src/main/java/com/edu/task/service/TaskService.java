package com.edu.task.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.edu.task.dao.TaskRepo;
import com.edu.task.exception.ResourceNotFoundException;
import com.edu.task.model.dto.InputTaskDto;
import com.edu.task.model.dto.TaskDto;
import com.edu.task.model.entity.Task;

@Component
public class TaskService {

    private TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
	this.taskRepo = taskRepo;
    }

    public TaskDto getTask(Long id) {
	Task task = taskRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
	TaskDto taskDto = new TaskDto();
	taskDto.setId(task.getId());
	taskDto.setTitle(task.getTitle());
	taskDto.setDescription(task.getDescription());
	taskDto.setStatus(task.getStatus());
	taskDto.setPriority(task.getPriority());
	taskDto.setCreatedAt(task.getCreatedAt());
	taskDto.setUpdatedAt(task.getUpdatedAt());
	return taskDto;
    }

    public List<TaskDto> getTasks() {
	List<Task> tasks = taskRepo.findAll();
	return tasks.stream().map(t -> {
	    TaskDto taskDto = new TaskDto();
	    taskDto.setId(t.getId());
	    taskDto.setTitle(t.getTitle());
	    taskDto.setDescription(t.getDescription());
	    taskDto.setStatus(t.getStatus());
	    taskDto.setPriority(t.getPriority());
	    taskDto.setCreatedAt(t.getCreatedAt());
	    taskDto.setUpdatedAt(t.getUpdatedAt());
	    return taskDto;
	}).collect(Collectors.toList());
    }

    public Long createTask(InputTaskDto createTaskDto) {
	Task saveTask = new Task();
	saveTask.setTitle(createTaskDto.getTitle());
	saveTask.setDescription(createTaskDto.getDescription());
	saveTask.setStatus(createTaskDto.getStatus());
	saveTask.setPriority(createTaskDto.getPriority());
	saveTask.setCreatedAt(OffsetDateTime.now());
	return taskRepo.save(saveTask).getId();
    }

    public void updateTask(Long id, InputTaskDto updateTaskDto) {
	Task updateTask = taskRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
	updateTask.setId(id);
	updateTask.setTitle(updateTaskDto.getTitle());
	updateTask.setDescription(updateTaskDto.getDescription());
	updateTask.setStatus(updateTaskDto.getStatus());
	updateTask.setPriority(updateTaskDto.getPriority());
	updateTask.setUpdatedAt(OffsetDateTime.now());
	taskRepo.save(updateTask);
    }

    public void deleteTask(Long id) {
	taskRepo.deleteById(id);
    }

}
