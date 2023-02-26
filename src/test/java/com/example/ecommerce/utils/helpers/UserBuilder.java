package com.example.ecommerce.utils.helpers;

import com.example.ecommerce.api.v1.model.UserDTO;
import com.example.ecommerce.domain.security.User;

import java.util.UUID;

public class UserBuilder {
    private static final String ID = "bd1cdd25-c1cd-445a-b6a4-3518f46f5e2a";
    private static final String UNAME = "MyTestUser";

    private static final String PWD = "Admin123";
    private static final String EMAIL = "example@examplemail.com";

    public static User build() {
        User user = new User();
        user.setId(UUID.fromString(ID));
        user.setEmail(EMAIL);
        user.setUsername(UNAME);
        user.setPassword(PWD);

        return user;
    }

    public static UserDTO buildDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(ID);
        userDTO.setName(UNAME);
        userDTO.setPassword(PWD);
        userDTO.setEmail(EMAIL);

        return userDTO;
    }
}
