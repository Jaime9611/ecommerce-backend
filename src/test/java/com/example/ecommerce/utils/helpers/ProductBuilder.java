package com.example.ecommerce.utils.helpers;

import com.example.ecommerce.domain.Product;

import java.util.UUID;

public class ProductBuilder {
    private static final String ID = "bd1cdd25-c1cd-445a-b6a4-3518f46f5e2b";
    private static final String NAME = "Test Product";
    private static final String DESC = "Test Description for product.";
    private static final Double PRICE = 123.3;

    public static Product build() {
        Product product = new Product();
        product.setId(UUID.fromString(ID));
        product.setName(NAME);
        product.setDescription(DESC);
        product.setPrice(PRICE);
        product.setInventory(ProductInventoryBuilder.build());
        product.setCategory(ProductCategoryBuilder.build());

        return product;
    }

}
