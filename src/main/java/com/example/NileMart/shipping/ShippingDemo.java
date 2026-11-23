package com.example.NileMart.shipping;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ShippingDemo {
   private final List<ShippingService>shippingServiceList;
    ShippingDemo(List<ShippingService>shippingServiceList){
        this.shippingServiceList=shippingServiceList;
    }
    public void testShipping(){
        for(ShippingService shippingService:shippingServiceList){
            System.out.println(shippingService.calculateShippingCost());
        }
    }
}
