package com.wkur3k.ToDoApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TaskDto {
    private String name;
    private String description;
    private List<StatusHistoryDto> statuses;
    private String author;
}
