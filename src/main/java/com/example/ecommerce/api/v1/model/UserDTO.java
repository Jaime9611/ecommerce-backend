package com.example.ecommerce.api.v1.model;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String name;
    private String password;
    private String email;
}
