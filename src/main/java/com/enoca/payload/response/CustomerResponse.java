package com.enoca.payload.response;

import com.enoca.model.Product;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CustomerResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private List<Product> products;



}
