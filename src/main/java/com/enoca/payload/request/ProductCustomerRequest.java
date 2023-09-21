package com.enoca.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCustomerRequest {

    @NotNull(message = "Product id must not be null")
    private int productId;
    @NotNull(message = "Customer id must not be null")
    private int customerId;
}
