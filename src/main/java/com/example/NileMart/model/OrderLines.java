package com.example.NileMart.model;

import java.math.BigDecimal;

public class OrderLines {
    private Product p;
    private int quantity;
    private BigDecimal LinePrice =p.getPrice().multiply(BigDecimal.valueOf(quantity));
}
