package com.example.ecommerce.domain;

import com.example.ecommerce.utils.constants.TableConstants;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = TableConstants.TABLE_NAME_PRODUCT)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = TableConstants.TYPE_UUID)
  private UUID id;

  @NotNull
  @NotBlank
  @Size(min = 2, max = 100)
  private String name;

  @NotNull
  @NotBlank
  @Size(min = 10, max = 255)
  private String description;

  @NotNull
  @NotBlank
  private Double price;

  @NotNull
  @NotBlank
  @Column(name = "image_url")
  private String imageUrl;

  @OneToOne
  @JoinColumn(name = "inventory_id")
  private ProductInventory inventory;

  @ManyToMany
  @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
  private Set<ProductCategory> categories = new HashSet<>();
}