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
@Table(name = "st_role")
@Entity
public class RoleModel {
    @Id
    @Column(name = "role_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_description", nullable = false)
    private String description;

    @Column(name = "role_created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;

    @Column(name = "role_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private StatusModel status;
}
