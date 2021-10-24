package com.taskmanagerback.taskmanagerback.repository;

import com.taskmanagerback.taskmanagerback.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
