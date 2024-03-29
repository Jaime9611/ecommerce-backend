package com.example.ecommerce.api.v1.mapper;

import com.example.ecommerce.api.v1.model.UserDTO;
import com.example.ecommerce.domain.security.User;
import com.example.ecommerce.utils.helpers.UserBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void shouldConvertUsertoUserDTO() throws Exception {
        // Given
        User testUser = UserBuilder.build();

        // When
        UserDTO userDTO = userMapper.userToUserDTO(testUser);

        // Then
        assertEquals(testUser.getId().toString(), userDTO.getId());
        assertEquals(testUser.getUsername(), userDTO.getName());
        assertEquals(testUser.getEmail(), userDTO.getEmail());
    }

    @Test
    public void shouldConvertUserDTOtoUser() throws Exception {
        // Given
        UserDTO testUserDTO = UserBuilder.buildDTO();

        // When
        User user = userMapper.userDtoToUser(testUserDTO);

        // Then
        assertEquals(testUserDTO.getId(), user.getId().toString());
        assertEquals(testUserDTO.getName(), user.getUsername());
        assertEquals(testUserDTO.getEmail(), user.getEmail());
    }
}
