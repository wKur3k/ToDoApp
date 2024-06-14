package com.wkur3k.ToDoApp.validations;

import com.wkur3k.ToDoApp.dtos.RegisterUserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegisterUserDto> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(RegisterUserDto registerUserDto, ConstraintValidatorContext context) {
        return registerUserDto.getPassword().equals(registerUserDto.getPasswordConfirm());
    }
}
