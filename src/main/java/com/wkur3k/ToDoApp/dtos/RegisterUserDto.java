package com.wkur3k.ToDoApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterUserDto {
    private String username;
    private String password;
    private String confirmPassword;
}
