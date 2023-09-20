package com.enoca.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductRequest {

    @NotNull(message = "Name must not be null")
    private String name;

    @NotNull(message = "Description must not be null")
    private String description;

    @NotNull(message = "Price must not be null")
    private double price;

    @NotNull(message = "Stock must not be null")
    private int stock;

    @NotNull(message = "Brand must not be null")
    private String brand;



}
