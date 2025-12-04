package com.theawesomeengineer.mapper;

import java.time.ZoneOffset;

import com.theawesomeengineer.entity.TaskEntity;
import com.theawesomeengineer.model.Task;
import com.theawesomeengineer.model.TaskRequest;
public class TaskMapper {

    public static Task toApi(TaskEntity e) {
        if (e == null) return null;
        Task t = new Task();
        t.setId(e.getId());
        t.setTitle(e.getTitle());
        t.setDescription(e.getDescription());
        t.setCompleted(e.getCompleted());
        t.setCreatedAt(e.getCreatedAt() != null ? e.getCreatedAt().atOffset(ZoneOffset.UTC) : null);
        t.setUpdatedAt(e.getUpdatedAt() != null ? e.getUpdatedAt().atOffset(ZoneOffset.UTC) : null);
        return t;
    }

    public static TaskEntity fromRequest(TaskRequest r) {
        if (r == null) return null;
        TaskEntity e = new TaskEntity();
        e.setTitle(r.getTitle());
        e.setDescription(r.getDescription());
        e.setCompleted(r.getCompleted() != null ? r.getCompleted() : false);
        return e;
    }

    public static void updateEntityFromRequest(TaskEntity e, TaskRequest r) {
        if (r == null || e == null) return;
        if (r.getTitle() != null) e.setTitle(r.getTitle());
        if (r.getDescription() != null) e.setDescription(r.getDescription());
        if (r.getCompleted() != null) e.setCompleted(r.getCompleted());
    }
}