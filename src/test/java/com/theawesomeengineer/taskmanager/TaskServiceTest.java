package com.theawesomeengineer.taskmanager;

import com.theawesomeengineer.entity.TaskEntity;
import com.theawesomeengineer.mapper.TaskMapper;
import com.theawesomeengineer.model.Task;
import com.theawesomeengineer.model.TaskRequest;
import com.theawesomeengineer.repository.TaskRepository;
import com.theawesomeengineer.service.TaskServiceImpl;
import com.theawesomeengineer.exception.NotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void testCreateTask() {
        TaskRequest request = new TaskRequest();
        request.setTitle("Title");
        request.setDescription("Desc");
        request.setCompleted(false);

        TaskEntity entity = TaskMapper.fromRequest(request);
        entity.setId(1L);
        when(taskRepository.save(any(TaskEntity.class))).thenReturn(entity);

        Task created = taskService.create(request);
        assertEquals("Title", created.getTitle());
        assertFalse(created.getCompleted());
        verify(taskRepository, times(1)).save(any(TaskEntity.class));
    }

    @Test
    void testGetByIdFound() {
        TaskEntity entity = new TaskEntity();
        entity.setId(1L);
        entity.setTitle("Title");
        entity.setDescription("Desc");
        entity.setCompleted(false);
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());

        when(taskRepository.findById(1L)).thenReturn(Optional.of(entity));

        Task found = taskService.getById(1L);
        assertEquals("Title", found.getTitle());
        assertFalse(found.getCompleted());
    }

    @Test
    void testGetByIdNotFound() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> taskService.getById(1L));
    }

    @Test
    void testGetAll() {
        TaskEntity entity1 = new TaskEntity();
        entity1.setId(1L);
        entity1.setTitle("Task 1");
        entity1.setCompleted(false);

        TaskEntity entity2 = new TaskEntity();
        entity2.setId(2L);
        entity2.setTitle("Task 2");
        entity2.setCompleted(true);

        List<TaskEntity> list = new ArrayList<>();
        list.add(entity1);
        list.add(entity2);

        when(taskRepository.findAll()).thenReturn(list);

        List<Task> allTasks = taskService.getAll();
        assertEquals(2, allTasks.size());
        assertEquals("Task 1", allTasks.get(0).getTitle());
        assertEquals("Task 2", allTasks.get(1).getTitle());
    }

    @Test
    void testUpdateTask() {
        TaskRequest request = new TaskRequest();
        request.setTitle("Updated Title");
        request.setDescription("Updated Desc");
        request.setCompleted(true);

        TaskEntity entity = new TaskEntity();
        entity.setId(1L);
        entity.setTitle("Old Title");
        entity.setDescription("Old Desc");
        entity.setCompleted(false);
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());

        when(taskRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(taskRepository.save(any(TaskEntity.class))).thenReturn(entity);

        Task updated = taskService.update(1L, request);
        assertEquals("Updated Title", updated.getTitle());
        assertTrue(updated.getCompleted());
        verify(taskRepository, times(1)).save(entity);
    }

    @Test
    void testDeleteTask() {
        when(taskRepository.existsById(1L)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(1L);

        taskService.delete(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteTaskNotFound() {
        when(taskRepository.existsById(1L)).thenReturn(false);
        assertThrows(NotFoundException.class, () -> taskService.delete(1L));
    }
}
