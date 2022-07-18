package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.model.ProductDTO;

public interface ProductService {
    public ProductDTO getProductById(String id);
}
