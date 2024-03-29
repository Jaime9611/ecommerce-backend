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
        Product testProduct = ProductBuilder.build(false);

        // When
        ProductDTO productDTO = productMapper.productToProductDTO(testProduct);

        // Then
        assertEquals(testProduct.getId().toString(), productDTO.getId());
        assertEquals(testProduct.getName(), productDTO.getName());
        assertEquals(testProduct.getDescription(), productDTO.getDesc());
        assertEquals(testProduct.getPrice(), productDTO.getPrice());
        assertEquals(testProduct.getCategories().stream().findFirst().get().getId().toString(), productDTO.getCategories().get(0).getId());
        assertEquals(testProduct.getInventory().getId().toString(), productDTO.getInventory().getId());
    }

    @Test
    public void shouldConvertProductDTOtoProduct() throws Exception {
        // Given
        ProductDTO testProductDTO = ProductBuilder.buildDTO();

        // When
        Product product = productMapper.productDtoToProduct(testProductDTO);

        // Then
        assertEquals(testProductDTO.getId(), product.getId().toString());
        assertEquals(testProductDTO.getName(), product.getName());
        assertEquals(testProductDTO.getDesc(), product.getDescription());
        assertEquals(testProductDTO.getPrice(), product.getPrice());
        assertEquals(testProductDTO.getCategories().get(0).getId(), product.getCategories().stream().findFirst().get().getId().toString());
        assertEquals(testProductDTO.getInventory().getId(), product.getInventory().getId().toString());
    }
}
