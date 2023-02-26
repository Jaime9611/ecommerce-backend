package com.example.ecommerce.repositories;

import com.example.ecommerce.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
