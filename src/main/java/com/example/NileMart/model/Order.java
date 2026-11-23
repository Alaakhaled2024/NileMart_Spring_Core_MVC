package com.example.NileMart.model;

import java.util.List;

public class Order {
    private Double OrderNum;
    private Customer customer;
    List<OrderLines> orderLines;
    private Double subtotal;
    private Double vat;
    private Double sh_fee;
    private Double total;
}
