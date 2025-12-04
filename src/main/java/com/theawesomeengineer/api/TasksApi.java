package com.theawesomeengineer.api;

import com.theawesomeengineer.model.Error;
import com.theawesomeengineer.model.Task;
import com.theawesomeengineer.model.TaskRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.17.0")
@Validated
@Tag(name = "Tasks", description = "the Tasks API")
public interface TasksApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    String PATH_CREATE_TASK = "/tasks";
    /**
     * POST /tasks : Create a new task
     * Create a new task with the provided information
     *
     * @param taskRequest  (required)
     * @return Task created successfully (status code 201)
     *         or Invalid input (status code 400)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "createTask",
        summary = "Create a new task",
        description = "Create a new task with the provided information",
        tags = { "Tasks" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Task created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = TasksApi.PATH_CREATE_TASK,
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Task> createTask(
        @Parameter(name = "TaskRequest", description = "", required = true) @Valid @RequestBody TaskRequest taskRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2024-01-01T10:00:00Z\", \"description\" : \"Write comprehensive documentation for the task management API\", \"id\" : 1, \"completed\" : false, \"title\" : \"Complete project documentation\", \"updatedAt\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    String PATH_DELETE_TASK = "/tasks/{id}";
    /**
     * DELETE /tasks/{id} : Delete task by ID
     * Delete a specific task by its ID
     *
     * @param id Task ID (required)
     * @return Task deleted successfully (status code 204)
     *         or Task not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "deleteTask",
        summary = "Delete task by ID",
        description = "Delete a specific task by its ID",
        tags = { "Tasks" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Task deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = TasksApi.PATH_DELETE_TASK,
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deleteTask(
        @NotNull @Parameter(name = "id", description = "Task ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    String PATH_GET_ALL_TASKS = "/tasks";
    /**
     * GET /tasks : Get all tasks
     * Retrieve a list of all tasks
     *
     * @return List of tasks retrieved successfully (status code 200)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "getAllTasks",
        summary = "Get all tasks",
        description = "Retrieve a list of all tasks",
        tags = { "Tasks" },
        responses = {
            @ApiResponse(responseCode = "200", description = "List of tasks retrieved successfully", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Task.class)))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = TasksApi.PATH_GET_ALL_TASKS,
        produces = { "application/json" }
    )
    default ResponseEntity<List<Task>> getAllTasks(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"createdAt\" : \"2024-01-01T10:00:00Z\", \"description\" : \"Write comprehensive documentation for the task management API\", \"id\" : 1, \"completed\" : false, \"title\" : \"Complete project documentation\", \"updatedAt\" : \"2024-01-01T10:00:00Z\" }, { \"createdAt\" : \"2024-01-01T10:00:00Z\", \"description\" : \"Write comprehensive documentation for the task management API\", \"id\" : 1, \"completed\" : false, \"title\" : \"Complete project documentation\", \"updatedAt\" : \"2024-01-01T10:00:00Z\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    String PATH_GET_TASK_BY_ID = "/tasks/{id}";
    /**
     * GET /tasks/{id} : Get task by ID
     * Retrieve a specific task by its ID
     *
     * @param id Task ID (required)
     * @return Task retrieved successfully (status code 200)
     *         or Task not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "getTaskById",
        summary = "Get task by ID",
        description = "Retrieve a specific task by its ID",
        tags = { "Tasks" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Task retrieved successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
            }),
            @ApiResponse(responseCode = "404", description = "Task not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = TasksApi.PATH_GET_TASK_BY_ID,
        produces = { "application/json" }
    )
    default ResponseEntity<Task> getTaskById(
        @NotNull @Parameter(name = "id", description = "Task ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2024-01-01T10:00:00Z\", \"description\" : \"Write comprehensive documentation for the task management API\", \"id\" : 1, \"completed\" : false, \"title\" : \"Complete project documentation\", \"updatedAt\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    String PATH_UPDATE_TASK = "/tasks/{id}";
    /**
     * PUT /tasks/{id} : Update task by ID
     * Update an existing task with the provided information
     *
     * @param id Task ID (required)
     * @param taskRequest  (required)
     * @return Task updated successfully (status code 200)
     *         or Invalid input (status code 400)
     *         or Task not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "updateTask",
        summary = "Update task by ID",
        description = "Update an existing task with the provided information",
        tags = { "Tasks" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Task updated successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "Task not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = TasksApi.PATH_UPDATE_TASK,
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Task> updateTask(
        @NotNull @Parameter(name = "id", description = "Task ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "TaskRequest", description = "", required = true) @Valid @RequestBody TaskRequest taskRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2024-01-01T10:00:00Z\", \"description\" : \"Write comprehensive documentation for the task management API\", \"id\" : 1, \"completed\" : false, \"title\" : \"Complete project documentation\", \"updatedAt\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"details\" : \"Task with ID 123 does not exist\", \"message\" : \"Task not found\", \"timestamp\" : \"2024-01-01T10:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}