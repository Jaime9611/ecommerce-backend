package com.example.ecommerce.bootstrap;

import com.example.ecommerce.domain.security.Authority;
import com.example.ecommerce.domain.security.Role;
import com.example.ecommerce.domain.security.User;
import com.example.ecommerce.repositories.AuthorityRepository;
import com.example.ecommerce.repositories.RoleRepository;
import com.example.ecommerce.repositories.UserRepository;
import java.util.Arrays;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDataLoader implements CommandLineRunner {

  private final AuthorityRepository authorityRepository;

  private final RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  private void loadSecurityData() {
    // product auths
    Authority createProduct = authorityRepository.save(
        Authority.builder().permission("product.create").build());
    Authority readProduct = authorityRepository.save(
        Authority.builder().permission("product.read").build());
    Authority updateProduct = authorityRepository.save(
        Authority.builder().permission("product.update").build());
    Authority deleteProduct = authorityRepository.save(
        Authority.builder().permission("product.delete").build());

    // user roles
    Role adminRole = roleRepository.save(Role.builder().name("ADMIN").build());
    Role customerRole = roleRepository.save(Role.builder().name("CUSTOMER").build());
    Role userRole = roleRepository.save(Role.builder().name("USER").build());

    adminRole.setAuthorities(Set.of(readProduct, createProduct, updateProduct, deleteProduct));
    userRole.setAuthorities(Set.of(readProduct));
    customerRole.setAuthorities(Set.of(readProduct));

    roleRepository.saveAll(Arrays.asList(adminRole, userRole, customerRole));

    PasswordEncoder bcrypt = new BCryptPasswordEncoder();

    userRepository.save(User.builder()
        .username("james")
        .password(bcrypt.encode("test123"))
        .role(adminRole)
        .build());

    userRepository.save(User.builder()
        .username("user")
        .password(bcrypt.encode("test123"))
        .role(userRole)
        .build());

    log.debug("Users loaded.");
  }


  @Override
  public void run(String... args) throws Exception {
    if (authorityRepository.count() == 0) {
      loadSecurityData();
    }
  }
}
