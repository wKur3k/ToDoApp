package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.entities.StatusEnum;
import com.wkur3k.ToDoApp.entities.StatusHistory;
import com.wkur3k.ToDoApp.entities.Task;
import com.wkur3k.ToDoApp.repositories.StatusHistoryRepository;
import com.wkur3k.ToDoApp.repositories.StatusRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusHistoryService implements IStatusHistoryService {
    private final StatusHistoryRepository statusHistoryRepository;
    private final StatusRepository statusRepository;

    public StatusHistoryService(StatusHistoryRepository statusHistoryRepository, StatusRepository statusRepository) {
        this.statusHistoryRepository = statusHistoryRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void create(Task task, StatusEnum status){
        StatusHistory statusHistory = new StatusHistory();
        statusHistory.setTask(task);
        statusHistory.setStatus(statusRepository.findByName(status).get());
        statusHistoryRepository.save(statusHistory);
    }
}
