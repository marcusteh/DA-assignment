package com.theawesomeengineer.taskmanager;

import com.theawesomeengineer.model.Task;
import com.theawesomeengineer.model.TaskRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.junit.jupiter.Container;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskmanagerApplicationTests {
    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.driver-class-name",
                () -> "com.mysql.cj.jdbc.Driver");
    }

    @Autowired
    private TestRestTemplate restTemplate;

    private Long taskId;

    @BeforeEach
    void setup() {
        // Create a task to use for GET/PUT/DELETE tests
        TaskRequest request = new TaskRequest();
        request.setTitle("Integration Test Task");
        request.setDescription("Test Description");
        request.setCompleted(false);

        ResponseEntity<Task> response = restTemplate.postForEntity("/tasks", request, Task.class);
        taskId = Objects.requireNonNull(response.getBody()).getId();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testGetTaskById() {
        ResponseEntity<Task> response = restTemplate.getForEntity("/tasks/" + taskId, Task.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Integration Test Task", Objects.requireNonNull(response.getBody()).getTitle());
    }

    @Test
    void testGetAllTasks() {
        ResponseEntity<Task[]> response = restTemplate.getForEntity("/tasks", Task[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    void testUpdateTask() {
        TaskRequest updateRequest = new TaskRequest();
        updateRequest.setTitle("Updated Task");
        updateRequest.setDescription("Updated Description");
        updateRequest.setCompleted(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TaskRequest> entity = new HttpEntity<>(updateRequest, headers);

        ResponseEntity<Task> response = restTemplate.exchange("/tasks/" + taskId, HttpMethod.PUT, entity, Task.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Task", Objects.requireNonNull(response.getBody()).getTitle());
    }

    @Test
    void testDeleteTask() {
        restTemplate.delete("/tasks/" + taskId);

        ResponseEntity<Task> response = restTemplate.getForEntity("/tasks/" + taskId, Task.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
