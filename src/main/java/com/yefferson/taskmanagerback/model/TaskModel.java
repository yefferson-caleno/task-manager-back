package com.yefferson.taskmanagerback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dy_task")
@Entity
public class TaskModel {
    @Id
    @Column(name = "task_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_title", nullable = false)
    private String title;

    @Column(name = "task_description")
    private String description;

    @Column(name = "task_init")
    private LocalDateTime taskInit;

    @Column(name = "task_end")
    private LocalDateTime taskEnd;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private TeamModel team;

    @ManyToOne
    @JoinColumn(name = "user_assigned_id", referencedColumnName = "user_id")
    private UserModel userAssigned;

    @ManyToOne
    @JoinColumn(name = "user_created_email", referencedColumnName = "user_email")
    private UserModel userCreated;

    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    private StateModel state;

    @Column(name = "task_created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @Column(name = "task_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private StatusModel status;
}
