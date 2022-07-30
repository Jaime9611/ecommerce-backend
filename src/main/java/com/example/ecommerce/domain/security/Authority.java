package com.example.ecommerce.domain.security;

import com.example.ecommerce.utils.constants.TableConstants;
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
@Table(name = TableConstants.TABLE_NAME_AUTHORITY)
public class Authority {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String permission;

  @ManyToMany(mappedBy = "authorities")
  private Set<Role> roles;

}
