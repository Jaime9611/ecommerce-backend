package com.example.ecommerce.controllers.v1;

import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.utils.constants.Endpoints;
import java.util.List;
import java.util.UUID;
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

  @GetMapping("/{categoryId}")
  public ResponseEntity<List<ProductDTO>> getAllProductsbyCategory(
      @PathVariable UUID categoryId) {
    return ResponseEntity.ok(productService.getAllProductsByCategoryId(categoryId));
  }
}
