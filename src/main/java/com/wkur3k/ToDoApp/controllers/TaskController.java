package com.wkur3k.ToDoApp.controllers;

import com.wkur3k.ToDoApp.dtos.TaskCreateDto;
import com.wkur3k.ToDoApp.dtos.TaskDto;
import com.wkur3k.ToDoApp.entities.StatusEnum;
import com.wkur3k.ToDoApp.services.ITaskService;
import com.wkur3k.ToDoApp.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/task")
@RestController
@Validated
@PreAuthorize("hasAnyRole('USER')")
public class TaskController {
    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public ResponseEntity<URI> create(@RequestBody TaskCreateDto dto, @AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(taskService.createTask(dto, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable int id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity ChangeStatus(@PathVariable int id, @RequestBody StatusEnum status){
        taskService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }
}
