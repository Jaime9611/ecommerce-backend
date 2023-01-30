package com.example.ecommerce.controllers.v1;

import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.utils.constants.Endpoints;
import java.util.List;
import java.util.UUID;

import com.example.ecommerce.utils.constants.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.PRODUCT_ENDPOINT)
@CrossOrigin(origins = "${react.origin.url}")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  @GetMapping(Paths.Products.GET_PRODUCT_BY_ID)
  public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID productId) {
    return ResponseEntity.ok(productService.getProductById(productId));
  }

  @GetMapping(Paths.Products.GET_PRODUCT_BY_CATEGORY)
  public ResponseEntity<List<ProductDTO>> getAllProductsByCategory(
      @PathVariable UUID categoryId) {
    return ResponseEntity.ok(productService.getAllProductsByCategoryId(categoryId));
  }
}
