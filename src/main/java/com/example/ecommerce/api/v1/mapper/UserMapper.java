package com.example.ecommerce.api.v1.mapper;

import com.example.ecommerce.api.v1.model.UserDTO;
import com.example.ecommerce.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "name")
    UserDTO userToUserDTO(User user);

}
