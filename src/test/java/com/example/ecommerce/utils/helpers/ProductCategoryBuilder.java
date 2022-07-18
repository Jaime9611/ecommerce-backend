package com.example.ecommerce.utils.helpers;

import com.example.ecommerce.api.v1.model.ProductCategoryDTO;
import com.example.ecommerce.domain.ProductCategory;

import java.util.UUID;

public class ProductCategoryBuilder {
    private static final String ID = "bd1cdd25-c1cd-445a-b6a4-3518f46f5e4a";
    private static final String NAME = "Category Test";

    public static ProductCategory build() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(UUID.fromString(ID));
        productCategory.setName(NAME);

        return productCategory;
    }

    public static ProductCategoryDTO buildDTO() {
        ProductCategoryDTO.ProductCategoryDTOBuilder productCategoryDTO = ProductCategoryDTO.builder();

        productCategoryDTO.id(ID);
        productCategoryDTO.name(NAME);

        return productCategoryDTO.build();
    }
}
