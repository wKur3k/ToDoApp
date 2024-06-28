package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.dtos.LoginUserDto;
import com.wkur3k.ToDoApp.dtos.RegisterUserDto;
import com.wkur3k.ToDoApp.entities.User;
import com.wkur3k.ToDoApp.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.wkur3k.ToDoApp.entities.Role;
import com.wkur3k.ToDoApp.repositories.RoleRepository;
import com.wkur3k.ToDoApp.entities.RoleEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder, RoleRepository roleRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User signup(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);
        if (optionalRole.isEmpty()) {
            return null;
        }

        var user = new User()
                .setUsername(input.getUsername())
                .setPassword(passwordEncoder.encode(input.getPassword()))
                .setRole(optionalRole.get());
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername()).orElseThrow();
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}