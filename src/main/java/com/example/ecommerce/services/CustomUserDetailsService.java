package com.example.ecommerce.services;

import com.example.ecommerce.domain.security.Authority;
import com.example.ecommerce.domain.security.User;
import com.example.ecommerce.repositories.UserRepository;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    log.debug("Getting USER info via JPA.");

    User user = userRepository.findByUsername(username).orElseThrow(() -> {
      return new RuntimeException("User name: " + username + " not found.");
    });
    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), user.getEnabled(), user.getAccountNonExpired(),
        user.getAccountNonLocked(), user.getCredentialsNonExpired(),
        convertToSpringAuthorities(user.getAuthorities()));
  }

  private Collection<? extends GrantedAuthority> convertToSpringAuthorities(
      Set<Authority> authorities) {
    if (authorities != null && authorities.size() > 0) {
      return authorities.stream()
          .map(Authority::getPermission)
          .map(SimpleGrantedAuthority::new)
          .collect(Collectors.toSet());
    } else {
      return new HashSet<>();
    }
  }


}
