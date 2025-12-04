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
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.17.0")
public class Error {

  private String message;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private @Nullable String details;

  public Error() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Error(String message, OffsetDateTime timestamp) {
    this.message = message;
    this.timestamp = timestamp;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error message
   * @return message
   */
  @NotNull 
  @Schema(name = "message", example = "Task not found", description = "Error message", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Timestamp when the error occurred
   * @return timestamp
   */
  @NotNull @Valid 
  @Schema(name = "timestamp", example = "2024-01-01T10:00Z", description = "Timestamp when the error occurred", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public Error details(@Nullable String details) {
    this.details = details;
    return this;
  }

  /**
   * Additional error details
   * @return details
   */
  
  @Schema(name = "details", example = "Task with ID 123 does not exist", description = "Additional error details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("details")
  public @Nullable String getDetails() {
    return details;
  }

  public void setDetails(@Nullable String details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.message, error.message) &&
        Objects.equals(this.timestamp, error.timestamp) &&
        Objects.equals(this.details, error.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, timestamp, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

