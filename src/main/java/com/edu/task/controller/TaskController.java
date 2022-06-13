package com.edu.task.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.task.model.dto.InputTaskDto;
import com.edu.task.model.dto.TaskDto;
import com.edu.task.service.TaskService;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
	this.taskService = taskService;
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id){
	TaskDto taskDto = taskService.getTask(id);
	return ResponseEntity.ok(taskDto);
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<TaskDto>> getTasks(){
	List<TaskDto> tasksDto = taskService.getTasks();
	return ResponseEntity.ok(tasksDto);
    }

    @PostMapping(value = "/tasks")
    public ResponseEntity<Void> createTask(@RequestBody InputTaskDto inputTaskDto) {
	Long id = taskService.createTask(inputTaskDto);
	return ResponseEntity.created(URI.create(id.toString())).build();
    }

    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable Long id, @RequestBody InputTaskDto inputTaskDto) {
	taskService.updateTask(id, inputTaskDto);
	return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
	taskService.deleteTask(id);
	return ResponseEntity.noContent().build();
    }

}
