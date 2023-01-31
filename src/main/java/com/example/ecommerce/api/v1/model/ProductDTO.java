package com.example.ecommerce.api.v1.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ProductDTO {

  private String id;
  private String name;
  private String desc;
  private Double price;
  private String imageUrl;
  private List<ProductCategoryDTO> categories;
  private ProductInventoryDTO inventory;
}
