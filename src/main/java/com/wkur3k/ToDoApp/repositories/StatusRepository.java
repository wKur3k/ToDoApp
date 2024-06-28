package com.wkur3k.ToDoApp.repositories;

import com.wkur3k.ToDoApp.entities.Status;
import com.wkur3k.ToDoApp.entities.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
    Optional<Status> findByName(StatusEnum name);
}
