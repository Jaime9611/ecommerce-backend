package com.example.ecommerce.security;

import com.example.ecommerce.domain.security.Role;
import com.example.ecommerce.domain.security.User;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.services.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

  public static final String KEY = "my-secret-key";

  @Autowired
  private UserRepository userRepository;

  public String generateToken(UserDetails userDetails) {
    Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
    Map<String, Object> claims = new HashMap<>();

    if (user.isPresent()) {
      List<String> roles = user.get().getRoles().stream().map(role -> role.getName())
          .collect(Collectors.toList());

      claims.put("roles", roles);
    }

    return Jwts.builder().setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
        .signWith(SignatureAlgorithm.HS256, KEY).compact();
  }

  public Boolean validate(String token, UserDetails userDetails) {
    return token != null && getUserNameToken(token).equals(userDetails.getUsername())
        && !isExpirated(token);
  }

  public String getUserNameToken(String token) {
    return getClaims(token).getSubject();
  }

  private Claims getClaims(String token) {
    return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
  }

  private boolean isExpirated(String token) {
    return getClaims(token).getExpiration().before(new Date());
  }
}
