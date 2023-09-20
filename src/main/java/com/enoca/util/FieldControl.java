package com.enoca.util;

import com.enoca.exception.ConflictException;
import com.enoca.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FieldControl {

    private final CustomerRepository customerRepository;


    public void checkDuplicate(String email){

        if(customerRepository.existsByEmail(email)){
            throw new ConflictException(String.format(Messages.CONFLICT_EMAIL,email));
        }


    }






}
