package com.enoca.controller;

import com.enoca.payload.request.ProductRequest;
import com.enoca.payload.response.ProductResponse;
import com.enoca.payload.response.ResponseMessage;
import com.enoca.service.ProductService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    //save
    @PostMapping("/save")
    public ResponseMessage<ProductResponse> saveProduct(@RequestBody @Valid ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseMessage<ProductResponse> updateProduct(@RequestBody @Valid ProductRequest productRequest, @PathVariable Integer id){
        return productService.updateProduct(productRequest,id);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseMessage<ProductResponse> deleteProduct(@PathVariable Integer id){

        return productService.deleteProduct(id);


    }
    //getAll
    @GetMapping("/getAll")
    public ResponseMessage<List<ProductResponse>> getAllProduct(){

        return productService.getAllProduct();

    }


    //getById
    @GetMapping("/getById/{id}")
    public ResponseMessage<ProductResponse> getById(@PathVariable Integer id){

        return productService.getById(id);
    }



}
