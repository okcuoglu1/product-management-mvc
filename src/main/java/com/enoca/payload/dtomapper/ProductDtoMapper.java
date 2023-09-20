package com.enoca.payload.dtomapper;

import com.enoca.model.Product;
import com.enoca.payload.request.ProductRequest;
import com.enoca.payload.response.ProductResponse;
import lombok.Data;

@Data
public class ProductDtoMapper {

    public Product createProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .stock(productRequest.getStock())
                .brand(productRequest.getBrand())
                .build();
    }

    public ProductResponse createProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .brand(product.getBrand())
                .build();
    }

}
