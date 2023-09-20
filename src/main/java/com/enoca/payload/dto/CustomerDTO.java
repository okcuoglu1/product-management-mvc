package com.enoca.payload.dto;

import com.enoca.model.Customer;
import com.enoca.payload.request.CustomerRequest;
import lombok.Data;

@Data
public class CustomerDTO {


    public Customer createCustomer(CustomerRequest request){

        return Customer.builder().
                firstName(request.getFirstName()).
                lastName(request.getLastName()).
                email(request.getEmail()).
                build();



    }


}
