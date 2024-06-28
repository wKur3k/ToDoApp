package com.wkur3k.ToDoApp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateDto {
    private String name;
    private String description;
}
