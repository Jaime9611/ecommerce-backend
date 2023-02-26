package com.example.ecommerce.utils.helpers;

import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductBuilder {
    private static final String ID = "bd1cdd25-c1cd-445a-b6a4-3518f46f5e2b";
    private static final String NAME = "Test Product";
    private static final String DESC = "Test Description for product.";
    private static final Double PRICE = 123.3;

    private static final int CATEGORIES_LENGTH = 2;

    public static Product build(boolean random) {
        Product product = new Product();
        product.setId(random ? UUID.randomUUID() : UUID.fromString(ID));
        product.setName(NAME);
        product.setDescription(DESC);
        product.setPrice(PRICE);
        product.setInventory(ProductInventoryBuilder.build());
        product.setCategories(ProductCategoryBuilder.buildList(CATEGORIES_LENGTH));

        return product;
    }

    public static List<Product> buildList(int quantity) {
        List<Product> products = new ArrayList<>();

        while (quantity > 0) {
            Product product = build(true);

            products.add(product);

            quantity--;
        }

        return products;
    }

    public static ProductDTO buildDTO() {
        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.id(ID);
        productDTO.name(NAME);
        productDTO.price(PRICE);
        productDTO.desc(DESC);
        productDTO.categories(ProductCategoryBuilder.buildListDTO(CATEGORIES_LENGTH));
        productDTO.inventory(ProductInventoryBuilder.buildDTO());

        return productDTO.build();

    }

}
