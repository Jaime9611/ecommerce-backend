package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.mapper.ProductMapper;
import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.domain.Product;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  ProductMapper productMapper = ProductMapper.INSTANCE;

  @Override
  public ProductDTO getProductById(UUID id) {
    Optional<Product> product = productRepository.findById(id);

    if (product.isPresent()) {
      return productMapper.productToProductDTO(product.get());
    }

    return null;
  }

  @Override
  public List<ProductDTO> getAllProductsByCategoryId(UUID categoryId) {

    List<Product> products = productRepository.findProductsByCategoriesId(categoryId);

    if (!products.isEmpty()) {
      return products.stream().map(product -> productMapper.productToProductDTO(product))
          .collect(Collectors.toList());
    }

    return null;
  }
}
