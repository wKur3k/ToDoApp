package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.dtos.StatusHistoryDto;
import com.wkur3k.ToDoApp.dtos.TaskCreateDto;
import com.wkur3k.ToDoApp.dtos.TaskDto;
import com.wkur3k.ToDoApp.entities.StatusEnum;
import com.wkur3k.ToDoApp.entities.Task;
import com.wkur3k.ToDoApp.repositories.TaskRepository;
import com.wkur3k.ToDoApp.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITaskService {
    private final IStatusHistoryService statusHistoryService;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, IStatusHistoryService statusHistoryService) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.statusHistoryService = statusHistoryService;
    }

    @Override
    public URI createTask(TaskCreateDto taskCreateDto, UserDetails userDetails) {
        Task task = new Task();
        task.setName(taskCreateDto.getName());
        task.setDescription(taskCreateDto.getDescription());
        task.setUser(userRepository.findByUsername(userDetails.getUsername()).get());
        taskRepository.save(task);
        statusHistoryService.create(task, StatusEnum.NEW);
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
    }

    @Override
    public TaskDto getTaskById(int id){
        Optional<Task> task = taskRepository.findById(id);
        return task.map(value -> new TaskDto(value.getName(),
                value.getDescription(),
                value.getStatusHistory().stream()
                        .map(statusHistory -> new StatusHistoryDto(
                                statusHistory.getStatus().getName().toString(),
                                statusHistory.getDate()
                        ))
                        .collect(Collectors.toList()),
                value.getUser().getUsername()
        )).orElse(null);
    }

    @Override
    public void updateStatus(int id, StatusEnum status){
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            statusHistoryService.create(task.get(), status);
        }
    }
}
