package com.enoca.controller;

import com.enoca.payload.request.CustomerRequest;
import com.enoca.payload.request.ProductCustomerRequest;
import com.enoca.payload.request.ProductRequest;
import com.enoca.payload.response.CreateProductForCustomerResponse;
import com.enoca.payload.response.CustomerResponse;
import com.enoca.payload.response.ResponseMessage;
import com.enoca.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseMessage<CustomerResponse> saveCustomer(@RequestBody @Valid CustomerRequest request) {
        return customerService.saveCustomer(request);
    }

    @PutMapping("/update/{id}")
    public ResponseMessage<CustomerResponse> updateCustomer(@PathVariable Integer id, @RequestBody @Valid CustomerRequest request){
        return customerService.updateCustomer(id,request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseMessage<CustomerResponse> deleteCustomer(@PathVariable Integer id){
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/getAll")
    public ResponseMessage<List<CustomerResponse>> getAllCustomer(){
       return customerService.getAllCustomer();
    }

    @GetMapping("/getById/{id}")
    public ResponseMessage<CustomerResponse> getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/createProduct")
    public ResponseMessage<CreateProductForCustomerResponse> createProductForCustomer(@RequestBody @Valid ProductCustomerRequest request){
        return customerService.createProductForCustomer(request);
    }
}
