package com.example.NileMart.Pricing;

import com.example.NileMart.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@Primary
public class StandardPricingService implements PricingService{
    @Override
  public   BigDecimal getPrice(Product product , int quantity){
        BigDecimal total= product.getPrice().multiply(BigDecimal.valueOf(quantity)) ;
        return total ;
    }



}
