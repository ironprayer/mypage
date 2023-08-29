package com.example.testforidearush.repository;

import com.example.testforidearush.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
