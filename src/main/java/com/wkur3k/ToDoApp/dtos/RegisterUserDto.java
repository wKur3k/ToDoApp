package com.wkur3k.ToDoApp.dtos;

import com.wkur3k.ToDoApp.validations.PasswordMatches;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@PasswordMatches
public class RegisterUserDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordConfirm;
}
