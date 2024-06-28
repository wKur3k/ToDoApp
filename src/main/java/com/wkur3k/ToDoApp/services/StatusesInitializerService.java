package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.entities.Status;
import com.wkur3k.ToDoApp.entities.StatusEnum;
import com.wkur3k.ToDoApp.repositories.StatusRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StatusesInitializerService {

    private final StatusRepository statusRepository;

    public StatusesInitializerService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @PostConstruct
    public void initStatuses(){
        Arrays.stream(StatusEnum.values()).forEach(status -> {
            if(statusRepository.findByName(status).isEmpty()){
                Status statusEntity = new Status();
                statusEntity.setName(status);
                statusRepository.save(statusEntity);
            }
        });
    }
}
