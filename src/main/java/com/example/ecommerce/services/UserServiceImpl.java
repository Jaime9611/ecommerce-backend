package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.mapper.UserMapper;
import com.example.ecommerce.api.v1.model.UserDTO;
import com.example.ecommerce.domain.User;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserDTO getUserById(UUID userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()) {
            return userMapper.userToUserDTO(user.get());
        }

        return null;
    }
}
