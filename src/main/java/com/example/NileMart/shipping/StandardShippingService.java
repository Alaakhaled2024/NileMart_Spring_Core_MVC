package com.example.NileMart.shipping;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class StandardShippingService implements ShippingService{

    @Override
    public double calculateShippingCost() {
        return 50 ;
    }
}
