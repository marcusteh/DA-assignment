package com.theawesomeengineer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import com.theawesomeengineer.repository.TaskRepository;
import com.theawesomeengineer.entity.TaskEntity;
import com.theawesomeengineer.model.Task;
import com.theawesomeengineer.model.TaskRequest;
import com.theawesomeengineer.mapper.TaskMapper;
import com.theawesomeengineer.exception.NotFoundException;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public Task create(TaskRequest request) {
        TaskEntity entity = TaskMapper.fromRequest(request);
        TaskEntity saved = repo.save(entity);
        return TaskMapper.toApi(saved);
    }

    @Override
    public Task getById(Long id) {
        TaskEntity entity = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found with id=" + id));
        return TaskMapper.toApi(entity);
    }

    @Override
    public List<Task> getAll() {
        return repo.findAll().stream().map(TaskMapper::toApi).collect(Collectors.toList());
    }

    @Override
    public Task update(Long id, TaskRequest request) {
        TaskEntity entity = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found with id=" + id));
        TaskMapper.updateEntityFromRequest(entity, request);
        TaskEntity saved = repo.save(entity);
        return TaskMapper.toApi(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Task not found with id=" + id);
        }
        repo.deleteById(id);
    }
}