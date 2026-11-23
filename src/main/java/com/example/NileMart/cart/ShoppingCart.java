package com.example.NileMart.cart;

import com.example.NileMart.model.Customer;
import com.example.NileMart.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
@Component
@Scope("prototype")
public class ShoppingCart {
    @Getter
    private int   number ;
    @Getter
    private Customer  customer;
    private	final LinkedHashMap <String, Integer>lines=new LinkedHashMap<>();
    private final ProductService productService ;
    private final int maxQuantityPerProduct;
    ShoppingCart(ProductService productService, @Value("${store.max-quantity-per-product}") int maxQuantityPerProduct){

     this.productService=productService;
    this.maxQuantityPerProduct=maxQuantityPerProduct;
    }










}
