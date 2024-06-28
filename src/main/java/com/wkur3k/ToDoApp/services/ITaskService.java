package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.dtos.TaskCreateDto;
import com.wkur3k.ToDoApp.dtos.TaskDto;
import com.wkur3k.ToDoApp.entities.StatusEnum;
import org.springframework.security.core.userdetails.UserDetails;

import java.net.URI;

public interface ITaskService {
    public URI createTask(TaskCreateDto taskCreateDto, UserDetails userDetails);
    public TaskDto getTaskById(int id);
    public void updateStatus(int id, StatusEnum status);
}
