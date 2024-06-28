package com.wkur3k.ToDoApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class StatusHistoryDto {
    private String status;
    private Date date;
}
