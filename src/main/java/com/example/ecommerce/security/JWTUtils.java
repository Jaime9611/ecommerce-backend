package com.example.ecommerce.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

  public static final String KEY = "my-secret-key";

  public String generateToken(UserDetails userDetails) {
    return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
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
