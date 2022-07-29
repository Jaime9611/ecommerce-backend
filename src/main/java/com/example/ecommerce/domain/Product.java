package com.example.ecommerce.domain;

import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = "uuid-char")
  private UUID id;

  @NotNull
  @NotBlank
  private String name;

  @NotNull
  @NotBlank
  @Size(min = 10, max = 255)
  private String description;

  @NotNull
  @NotBlank
  private Double price;

  @OneToOne
  @JoinColumn(name = "inventory_id")
  private ProductInventory inventory;

  @OneToOne
  @JoinColumn(name = "category_id")
  private ProductCategory category;
}