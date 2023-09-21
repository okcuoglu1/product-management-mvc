package com.enoca.payload.dtomapper;

import com.enoca.model.Customer;
import com.enoca.model.Product;
import com.enoca.payload.request.CustomerRequest;
import com.enoca.payload.response.CreateProductForCustomerResponse;
import com.enoca.payload.response.CustomerResponse;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDtoMapper {


    public Customer createCustomer(CustomerRequest request){

        return Customer.builder().
                firstName(request.getFirstName()).
                lastName(request.getLastName()).
                email(request.getEmail()).
                build();



    }

    public Customer createUpdatedCustomerById(CustomerRequest request, Integer id ){

        return Customer.builder().
                id(id).
                firstName(request.getFirstName()).
                lastName(request.getLastName()).
                email(request.getEmail()).
                build();



    }

    public CustomerResponse createCustomerResponse(Customer customer){

        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .products(customer.getProducts())
                .build();

    }

    public CreateProductForCustomerResponse createProductForCustomer(Customer customer, Product product){

        return CreateProductForCustomerResponse.builder()
                .customer(customer)
                .product(product)
                .build();

    }

}
