package com.example.NileMart.shipping;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class ExpressShippingService implements ShippingService{
    @Override
    public double calculateShippingCost() {
        return 100.0 ;
    }
}
