package com.theawesomeengineer.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.theawesomeengineer.entity.TaskEntity;
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}