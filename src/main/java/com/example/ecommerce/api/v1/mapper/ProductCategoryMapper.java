package com.example.ecommerce.api.v1.mapper;

import com.example.ecommerce.api.v1.model.ProductCategoryDTO;
import com.example.ecommerce.domain.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductCategoryMapper {
    ProductCategoryMapper INSTANCE = Mappers.getMapper(ProductCategoryMapper.class);

    ProductCategoryDTO productCategoryToProductCategoryDTO(ProductCategory productCategory);
}
