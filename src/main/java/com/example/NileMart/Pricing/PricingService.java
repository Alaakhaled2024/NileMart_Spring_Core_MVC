package com.example.NileMart.Pricing;

import com.example.NileMart.model.Product;

import java.math.BigDecimal;

public interface PricingService {
   public BigDecimal getPrice(Product product , int quantity);
}
