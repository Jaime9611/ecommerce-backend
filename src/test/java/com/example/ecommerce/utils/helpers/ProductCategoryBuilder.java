package com.example.ecommerce.utils.helpers;

import com.example.ecommerce.api.v1.model.ProductCategoryDTO;
import com.example.ecommerce.domain.Product;
import com.example.ecommerce.domain.ProductCategory;

import java.util.*;

public class ProductCategoryBuilder {
    private static final String ID = "bd1cdd25-c1cd-445a-b6a4-3518f46f5e4a";
    private static final String NAME = "Category Test";

    public static ProductCategory build(boolean random) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(random ? UUID.randomUUID() : UUID.fromString(ID));
        productCategory.setName(NAME);

        return productCategory;
    }

    public static Set<ProductCategory> buildList(int quantity) {
        List<ProductCategory> categories = new ArrayList<>();

        while (quantity > 0) {
            ProductCategory category = build(true);

            categories.add(category);

            quantity--;
        }

        return new HashSet<>(categories);
    }

    public static ProductCategoryDTO buildDTO(boolean random) {
        ProductCategoryDTO.ProductCategoryDTOBuilder productCategoryDTO = ProductCategoryDTO.builder();

        productCategoryDTO.id(random ? String.valueOf(UUID.randomUUID()) : ID);
        productCategoryDTO.name(NAME);

        return productCategoryDTO.build();
    }

    public static List<ProductCategoryDTO> buildListDTO(int quantity) {
        List<ProductCategoryDTO> categories = new ArrayList<>();

        while (quantity > 0) {
            ProductCategoryDTO category = buildDTO(true);

            categories.add(category);

            quantity--;
        }

        return categories;
    }
}
