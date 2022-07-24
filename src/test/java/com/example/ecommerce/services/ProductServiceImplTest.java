package com.example.ecommerce.services;

import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.domain.Product;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.utils.helpers.ProductBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    private static final int LIST_LENGTH = 10;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void shouldReturnProductDTOWhenGivenAnId() throws Exception {
        // GIVEN
        Product product = ProductBuilder.build(false);

        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.of(product));

        // WHEN
        ProductDTO productDTO = productService.getProductById(product.getId());

        // THEN
        assertEquals(product.getId().toString(), productDTO.getId());
        assertEquals(product.getName(), productDTO.getName());
        assertEquals(product.getDescription(), productDTO.getDesc());
        assertEquals(product.getPrice(), productDTO.getPrice());
        assertEquals(product.getInventory().getId().toString(), productDTO.getInventory().getId());
        assertEquals(product.getCategory().getId().toString(), productDTO.getCategory().getId());
    }

    @Test
    public void shouldReturnListOfProductDTOWhenGivenACategoryId() throws Exception {
        // GIVEN
        List<Product> products = ProductBuilder.buildList(LIST_LENGTH);

        when(productRepository.findAllByCategoryId(any(UUID.class))).thenReturn(products);

        // WHEN
        List<ProductDTO> productResp = productService.getAllProductsByCategoryId(products.get(0).getCategory().getId());

        // THEN
        assertEquals(LIST_LENGTH, productResp.size());
        assertEquals(products.get(3).getCategory().getName(), productResp.get(5).getCategory().getName());
    }
}
