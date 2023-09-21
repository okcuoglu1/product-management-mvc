package com.enoca.payload.response;

import com.enoca.model.Customer;
import com.enoca.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateProductForCustomerResponse {

    private Customer customer;
    private Product product;






}
