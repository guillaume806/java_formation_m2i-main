package com.example.demo_security_jwt.repository;

import com.example.demo_security_jwt.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

// Repository pour gérer les utilisateurs
public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);
    Boolean existsByEmail(String email);
}
