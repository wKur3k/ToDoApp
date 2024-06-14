package com.wkur3k.ToDoApp.controllers;

import com.wkur3k.ToDoApp.dtos.LoginResponseDto;
import com.wkur3k.ToDoApp.dtos.LoginUserDto;
import com.wkur3k.ToDoApp.dtos.RegisterUserDto;
import com.wkur3k.ToDoApp.entities.User;
import com.wkur3k.ToDoApp.services.AuthenticationService;
import com.wkur3k.ToDoApp.services.JwtService;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/auth")
@RestController
@Validated
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<URI> register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/{id}").buildAndExpand(registeredUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
