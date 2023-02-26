package com.example.ecommerce.controllers.v1;

import com.example.ecommerce.api.v1.model.AuthenticationRequest;
import com.example.ecommerce.api.v1.model.AuthenticationResponse;
import com.example.ecommerce.security.JWTUtils;
import com.example.ecommerce.services.CustomUserDetailsService;
import com.example.ecommerce.utils.constants.Endpoints;
import com.example.ecommerce.utils.constants.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.AUTH_ENDPOINT)
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Autowired
  private JWTUtils jwtUtils;

  @PostMapping(Paths.AUTHENTICATE)
  public ResponseEntity<AuthenticationResponse> createToken(
      @RequestBody AuthenticationRequest request) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
      UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUsername());

      String jwt = jwtUtils.generateToken(userDetails);

      return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    } catch (BadCredentialsException e) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

  }
}
