package com.example.taskapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TaskRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.17.0")
public class TaskRequest {

  private String title;

  private String description;

  private Boolean completed = false;

  public TaskRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TaskRequest(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public TaskRequest title(String title) {
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

  public TaskRequest description(String description) {
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

  public TaskRequest completed(Boolean completed) {
    this.completed = completed;
    return this;
  }

  /**
   * Whether the task is completed
   * @return completed
   */
  
  @Schema(name = "completed", example = "false", description = "Whether the task is completed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("completed")
  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskRequest taskRequest = (TaskRequest) o;
    return Objects.equals(this.title, taskRequest.title) &&
        Objects.equals(this.description, taskRequest.description) &&
        Objects.equals(this.completed, taskRequest.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, completed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
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

