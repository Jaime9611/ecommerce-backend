package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.model.ProductDTO;
import jdk.jfr.Category;

import java.util.List;
import java.util.UUID;

public interface ProductService {

  ProductDTO getProductById(UUID id);
  List<ProductDTO> getAllProducts();
  List<ProductDTO> getAllProductsByCategoryId(UUID categoryId);
}
