package com.example.ecommerce.api.v1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInventoryDTO {
    private String id;
    private int quantity;
}
