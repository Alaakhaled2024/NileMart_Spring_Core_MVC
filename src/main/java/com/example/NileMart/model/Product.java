package com.example.NileMart.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@AllArgsConstructor
public class  Product {
    @EqualsAndHashCode.Include
    private String sku;
    private String name;
    private Category category;
    private BigDecimal price;
    @Setter
    private int stockQuantity;

}

