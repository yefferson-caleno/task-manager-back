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
@Table(name = "dy_team")
@Entity
public class TeamModel {
    @Id
    @Column(name = "team_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_description", nullable = false, unique = true)
    private String description;

    @Column(name = "team_created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @Column(name = "team_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private StatusModel status;
}
