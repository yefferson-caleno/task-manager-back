package com.yefferson.taskmanagerback.repository;

import com.yefferson.taskmanagerback.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Long> {
    Optional<StatusModel> findByDescription(String description);
}
