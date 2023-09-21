package com.enoca.payload.response;


import com.enoca.model.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    private Integer id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String brand;
//    private Category category;
//    private List<Customer> customers;



}
