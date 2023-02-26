package com.example.ecommerce.domain;

import com.example.ecommerce.utils.constants.TableConstants;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = TableConstants.TABLE_NAME_CATEGORY)
public class ProductCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = TableConstants.TYPE_UUID)
  private UUID id;

  private String name;

  @ManyToMany(mappedBy = "categories")
  private Set<Product> products = new HashSet<>();
}
