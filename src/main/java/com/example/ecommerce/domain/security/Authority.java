package com.example.ecommerce.domain.security;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authority")
public class Authority {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String authority;

  @ManyToMany(mappedBy = "authorities")
  private Set<Role> roles;
  
}
