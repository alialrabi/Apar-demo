package com.example.demo.persistance.repos;

import com.example.demo.persistance.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}
