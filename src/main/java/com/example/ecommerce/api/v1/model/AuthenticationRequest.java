package com.example.ecommerce.api.v1.model;

import lombok.Data;

@Data
public class AuthenticationRequest {

  private String username;
  private String password;
}
