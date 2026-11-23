package com.example.NileMart.Pricing;

import com.example.NileMart.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class PromotionalPricingService implements PricingService{
    @Override
    public BigDecimal getPrice(Product product , int quantity){
        BigDecimal afterDiscount=new BigDecimal("0.8");
        BigDecimal total =product.getPrice().multiply(BigDecimal.valueOf(quantity)).multiply(afterDiscount);
        return total;
    }
}
