package com.example.ecommerce.utils.helpers;

import com.example.ecommerce.domain.ProductInventory;

import java.util.UUID;

public class ProductInventoryBuilder {
    private static final String ID = "bd1cdd25-c1cd-445a-b6a4-3518f46f5e3a";
    private static final int QUANTITY = 53;

    public static ProductInventory build() {
        ProductInventory productInventory = new ProductInventory();
        productInventory.setId(UUID.fromString(ID));
        productInventory.setQuantity(QUANTITY);

        return productInventory;
    }
}
