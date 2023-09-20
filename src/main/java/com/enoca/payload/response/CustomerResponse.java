package com.enoca.payload.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CustomerResponse {

    private String firstName;

    private String lastName;

    private String email;



}
