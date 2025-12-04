package com.theawesomeengineer.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.theawesomeengineer.model.Task;
import com.theawesomeengineer.model.TaskRequest;

@Service
public interface TaskService {
    Task create(TaskRequest request);
    Task getById(Long id);
    List<Task> getAll();
    Task update(Long id, TaskRequest request);
    void delete(Long id);
}