package com.example.taskapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Task
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.17.0")
public class Task {

  private Long id;

  private String title;

  private String description;

  private Boolean completed;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  public Task() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Task(Long id, String title, String description, Boolean completed, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.completed = completed;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Task id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the task
   * @return id
   */
  @NotNull 
  @Schema(name = "id", example = "1", description = "Unique identifier for the task", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Task title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title of the task
   * @return title
   */
  @NotNull @Size(max = 255) 
  @Schema(name = "title", example = "Complete project documentation", description = "Title of the task", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Task description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed description of the task
   * @return description
   */
  @NotNull @Size(max = 1000) 
  @Schema(name = "description", example = "Write comprehensive documentation for the task management API", description = "Detailed description of the task", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Task completed(Boolean completed) {
    this.completed = completed;
    return this;
  }

  /**
   * Whether the task is completed
   * @return completed
   */
  @NotNull 
  @Schema(name = "completed", example = "false", description = "Whether the task is completed", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("completed")
  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public Task createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Timestamp when the task was created
   * @return createdAt
   */
  @NotNull @Valid 
  @Schema(name = "createdAt", example = "2024-01-01T10:00Z", description = "Timestamp when the task was created", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Task updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Timestamp when the task was last updated
   * @return updatedAt
   */
  @NotNull @Valid 
  @Schema(name = "updatedAt", example = "2024-01-01T10:00Z", description = "Timestamp when the task was last updated", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.id, task.id) &&
        Objects.equals(this.title, task.title) &&
        Objects.equals(this.description, task.description) &&
        Objects.equals(this.completed, task.completed) &&
        Objects.equals(this.createdAt, task.createdAt) &&
        Objects.equals(this.updatedAt, task.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, completed, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

