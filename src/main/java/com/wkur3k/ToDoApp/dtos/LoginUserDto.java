package com.wkur3k.ToDoApp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginUserDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
