package com.example.demo.persistance.repos;

import com.example.demo.persistance.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
