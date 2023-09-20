package com.enoca.config;

import com.enoca.payload.dto.CustomerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateObjectBean {


    @Bean
    public CustomerDTO customerDTO() {
        return new CustomerDTO();
    }


}
