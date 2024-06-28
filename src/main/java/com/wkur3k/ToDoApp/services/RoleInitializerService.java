package com.wkur3k.ToDoApp.services;

import com.wkur3k.ToDoApp.entities.Role;
import com.wkur3k.ToDoApp.entities.RoleEnum;
import com.wkur3k.ToDoApp.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleInitializerService {

    private final RoleRepository roleRepository;

    public RoleInitializerService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initRoles(){
        Arrays.stream(RoleEnum.values()).forEach(role -> {
            if(roleRepository.findByName(role).isEmpty()){
                Role roleEntity = new Role();
                roleEntity.setName(role);
                roleRepository.save(roleEntity);
            }
        });
    }
}
