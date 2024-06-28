package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.entities.StatusEnum;
import com.wkur3k.ToDoApp.entities.Task;

public interface IStatusHistoryService {
    void create(Task task, StatusEnum status);
}
