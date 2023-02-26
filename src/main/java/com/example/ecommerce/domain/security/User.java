package com.example.ecommerce.domain.security;

import com.example.ecommerce.domain.UserAddress;
import com.example.ecommerce.utils.constants.TableConstants;
import java.util.stream.Collectors;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = TableConstants.TABLE_NAME_USER)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = TableConstants.TYPE_UUID)
  private UUID id;

  private String username;
  private String password;
  private String email;

  @Singular
  @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
  @JoinTable(name = "user_role", joinColumns = {
      @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
      @JoinColumn(name = "role_id", referencedColumnName = "id")})
  private Set<Role> roles;

  @Transient
  private Set<Authority> authorities;

  public Set<Authority> getAuthorities() {
    return this.roles.stream()
        .map(Role::getAuthorities)
        .flatMap(Set::stream)
        .collect(Collectors.toSet());
  }

  @OneToMany(mappedBy = "user")
  private List<UserAddress> userAddresses;

  @Builder.Default
  private Boolean accountNonExpired = true;

  @Builder.Default
  private Boolean accountNonLocked = true;

  @Builder.Default
  private Boolean credentialsNonExpired = true;

  @Builder.Default
  private Boolean enabled = true;
}
