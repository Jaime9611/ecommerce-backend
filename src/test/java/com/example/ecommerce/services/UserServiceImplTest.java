package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.model.UserDTO;
import com.example.ecommerce.domain.security.User;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.utils.helpers.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void shouldReturnUserDTOWhenGivenAnId() throws Exception {
        // GIVEN
        User user = UserBuilder.build();

        when(userRepository.findById(any(UUID.class))).thenReturn(Optional.of(user));

        // WHEN
        UserDTO userDto = userServiceImpl.getUserById(user.getId());

        // THEN
        assertEquals(user.getId().toString(), userDto.getId());
        assertEquals(user.getUsername(), userDto.getName());
        assertEquals(user.getEmail(), userDto.getEmail());
    }
}
