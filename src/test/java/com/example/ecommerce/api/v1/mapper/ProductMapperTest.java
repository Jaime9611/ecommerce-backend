package com.example.ecommerce.api.v1.mapper;

import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.domain.Product;
import com.example.ecommerce.utils.helpers.ProductBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {
    ProductMapper productMapper = ProductMapper.INSTANCE;

    @Test
    public void shouldConvertProductToProductDTO() throws Exception {
        // Given
        Product testProduct = ProductBuilder.build();

        // When
        ProductDTO productDTO = productMapper.productToProductDTO(testProduct);

        // Then
        assertEquals(testProduct.getId().toString(), productDTO.getId());
        assertEquals(testProduct.getName(), productDTO.getName());
        assertEquals(testProduct.getDescription(), productDTO.getDesc());
        assertEquals(testProduct.getPrice(), productDTO.getPrice());
        assertEquals(testProduct.getCategory().getId().toString(), productDTO.getCategory().getId());
        assertEquals(testProduct.getInventory().getId().toString(), productDTO.getInventory().getId());
    }
}
