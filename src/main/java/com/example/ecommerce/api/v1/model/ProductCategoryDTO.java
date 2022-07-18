package com.example.ecommerce.api.v1.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ProductCategoryDTO {
    private String id;
    private String name;
}
