package com.wkur3k.ToDoApp.repositories;

import com.wkur3k.ToDoApp.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findById(int id);
}
