package com.wkur3k.ToDoApp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="statuses")
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum name;
}
