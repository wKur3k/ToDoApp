package com.wkur3k.ToDoApp.repositories;

import com.wkur3k.ToDoApp.entities.Role;
import com.wkur3k.ToDoApp.entities.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
