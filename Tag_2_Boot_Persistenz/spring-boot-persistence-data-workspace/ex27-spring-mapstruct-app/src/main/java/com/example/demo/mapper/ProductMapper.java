package com.example.demo.mapper;
import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.domain.ProductDTO;
import com.example.demo.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProduct(ProductDTO productDTO);
}
