package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.mapper.ProductMapper;
import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.domain.Product;
import com.example.ecommerce.validations.exceptions.EntityNotFoundException;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    if (product.isEmpty()) {
      throw new EntityNotFoundException("Product", id);
    }

    return productMapper.productToProductDTO(product.get());
  }

  @Override
  public List<ProductDTO> getAllProducts() {
    List<Product> products = productRepository.findAll();

   return products.stream().map(product -> productMapper.productToProductDTO(product)).collect(Collectors.toList());
  }

  @Override
  public List<ProductDTO> getAllProductsByCategoryId(UUID categoryId) {

    List<Product> products = productRepository.findProductsByCategoriesId(categoryId);

    if (products.isEmpty()) {
      throw new EntityNotFoundException("Category", categoryId);
    }

    return products.stream().map(product -> productMapper.productToProductDTO(product))
            .collect(Collectors.toList());
  }
}
