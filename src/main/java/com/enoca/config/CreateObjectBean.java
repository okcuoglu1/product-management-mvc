package com.enoca.config;

import com.enoca.payload.dtomapper.CustomerDtoMapper;
import com.enoca.payload.dtomapper.ProductDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateObjectBean {


    @Bean
    public CustomerDtoMapper customerDTO() {
        return new CustomerDtoMapper();
    }


    @Bean
    public ProductDtoMapper productDto(){
        return new ProductDtoMapper();
    }
}
