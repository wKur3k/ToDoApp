package com.wkur3k.ToDoApp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "task")
    private List<StatusHistory> statusHistory;
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
}
