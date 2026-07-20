package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

// Step 2: Create the UserRepository[cite: 5]
public interface UserRepository extends JpaRepository<User, Long> {
}