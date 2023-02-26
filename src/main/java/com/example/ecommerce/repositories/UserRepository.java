package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.security.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByUsername(String username);
}
