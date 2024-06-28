package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.dtos.RegisterUserDto;
import com.wkur3k.ToDoApp.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("roleInitializerService")
public class UserInitializerService {
    @Autowired
    private AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public UserInitializerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initUsers(){
        if(userRepository.findByUsername("user").isEmpty()){
            authenticationService.signup(new RegisterUserDto("user", "user", "user"));
        }
    }
}
