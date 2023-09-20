package com.enoca.util;

import com.enoca.exception.ConflictException;
import com.enoca.repository.CustomerRepository;
import com.enoca.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FieldControl {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;


    public void checkDuplicateEmailForCustomer(String email){

        if(customerRepository.existsByEmail(email)){
            throw new ConflictException(String.format(Messages.CONFLICT_EMAIL,email));
        }


    }

    public void checkDuplicateNameForProduct(String name){

        if(productRepository.existsByName(name)){

            throw new ConflictException(String.format(Messages.CONFLICT_NAME,name));

        }


    }






}
