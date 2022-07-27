package com.example.ecommerce.domain.security;

import com.sun.source.doctree.SerialFieldTree;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  @Singular
  @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
  @JoinTable(name = "role_authority", joinColumns = {
      @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
      @JoinColumn(name = "authority_id", referencedColumnName = "id")})
  private Set<Authority> authorities;
}
