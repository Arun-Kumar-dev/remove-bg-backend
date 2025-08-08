package com.SaazApp.remove.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SaazApp.remove.Entity.UserEntity;

public interface  UserRepository extends  JpaRepository<UserEntity, Long> {
    boolean existsByClerkId(String clerkId);
    
    Optional<UserEntity> findByClerkId(String clerkId);
}
