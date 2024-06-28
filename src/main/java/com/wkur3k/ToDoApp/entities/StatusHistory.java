package com.wkur3k.ToDoApp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name="statusHistory")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class StatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="task_id")
    private Task task;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private Status status;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;
}
