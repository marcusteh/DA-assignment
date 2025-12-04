package com.theawesomeengineer.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.theawesomeengineer.api.TasksApi;
import com.theawesomeengineer.model.Task;
import com.theawesomeengineer.model.TaskRequest;
import com.theawesomeengineer.service.TaskService;

import java.util.List;

@RestController
public class TasksApiController implements TasksApi {

    private final TaskService taskService;

    public TasksApiController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @Override
    public ResponseEntity<Task> createTask(TaskRequest request) {
        Task created = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        Task t = taskService.getById(id);
        return ResponseEntity.ok(t);
    }

    @Override
    public ResponseEntity<Task> updateTask(Long id, TaskRequest request) {
        Task updated = taskService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deleteTask(Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}