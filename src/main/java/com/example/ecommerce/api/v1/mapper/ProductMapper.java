package com.example.ecommerce.api.v1.mapper;

import com.example.ecommerce.api.v1.model.ProductDTO;
import com.example.ecommerce.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "description", target = "desc")
    ProductDTO productToProductDTO(Product product);
}
