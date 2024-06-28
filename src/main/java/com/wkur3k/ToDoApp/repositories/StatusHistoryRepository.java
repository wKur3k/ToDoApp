package com.wkur3k.ToDoApp.repositories;

import com.wkur3k.ToDoApp.entities.StatusHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusHistoryRepository extends CrudRepository<StatusHistory, Integer> {

}
