package com.enoca.service;

import com.enoca.exception.NotFoundException;
import com.enoca.model.Product;
import com.enoca.payload.dtomapper.ProductDtoMapper;
import com.enoca.payload.request.ProductRequest;
import com.enoca.payload.response.ProductResponse;
import com.enoca.payload.response.ResponseMessage;
import com.enoca.repository.ProductRepository;
import com.enoca.util.FieldControl;
import com.enoca.util.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;
    private final FieldControl fieldControl;


    //!!! save
    public ResponseMessage<ProductResponse> saveProduct(ProductRequest productRequest) {

        System.out.println(productRequest);
        Product product = productDtoMapper.createProduct(productRequest);
        System.out.println(product);
        Product savedProduct =  productRepository.save(product);


        return ResponseMessage.<ProductResponse>builder()
                .object(productDtoMapper.createProductResponse(savedProduct))
                .message("Ürün Kaydedildi.")
                .httpStatus(HttpStatus.CREATED)
                .build();

    }


    //!!!update
    public ResponseMessage<ProductResponse> updateProduct(ProductRequest productRequest, Integer id) {

       Product product = productRepository.findById(id).orElseThrow(()->
               new NotFoundException(String.format(Messages.PRODUCT_NOT_FOUND,id)));

         fieldControl.checkDuplicateNameForProduct(productRequest.getName());

         Product updatedProduct = productDtoMapper.createProduct(productRequest);

         Product savedProduct = productRepository.save(updatedProduct);

         return ResponseMessage.<ProductResponse>builder()
                 .message(String.format("%s ID 'li Ürün Güncellendi."))
                 .object(productDtoMapper.createProductResponse(savedProduct))
                 .httpStatus(HttpStatus.OK)
                 .build();

    }


    //!!! delete
    public ResponseMessage<ProductResponse> deleteProduct(Integer id) {

        Product product = productRepository.findById(id).orElseThrow(()->
                new NotFoundException(String.format(Messages.PRODUCT_NOT_FOUND,id)));


        productRepository.deleteById(id);

        return ResponseMessage.<ProductResponse>builder()
                .message(String.format("%s ID 'li Ürün Silindi.",id))
                .object(productDtoMapper.createProductResponse(product))
                .httpStatus(HttpStatus.OK)
                .build();


    }

    //!!! GetALL
    public ResponseMessage<List<ProductResponse>> getAllProduct() {

        return ResponseMessage.<List<ProductResponse>>builder()
                .object(productRepository.findAll()
                        .stream()
                        .map(productDtoMapper::createProductResponse)
                        .collect(Collectors.toList()))
                .message("Tüm Ürünler Getirildi.")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    public ResponseMessage<ProductResponse> getById(Integer id) {

        Product product = productRepository.findById(id).orElseThrow(()->
                new NotFoundException(String.format(Messages.PRODUCT_NOT_FOUND,id)));

        return ResponseMessage.<ProductResponse>builder()
                .object(productDtoMapper.createProductResponse(product))
                .message(String.format("%s ID 'li Müşteri Getirildi."))
                .httpStatus(HttpStatus.OK)
                .build();

    }
}
