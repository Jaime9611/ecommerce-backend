package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.model.UserDTO;

import java.util.UUID;

public interface UserService {
    UserDTO getUserById(UUID userId);
}
