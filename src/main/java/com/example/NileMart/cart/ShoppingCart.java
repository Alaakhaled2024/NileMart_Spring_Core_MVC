package com.example.NileMart.cart;

import com.example.NileMart.common.Money;
import com.example.NileMart.common.OutOfStockException;
import com.example.NileMart.common.StoreException;
import com.example.NileMart.model.Customer;
import com.example.NileMart.model.Product;
import com.example.NileMart.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

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
 public void open(int number ,Customer customer){
        if(this.number!=0){
            throw new IllegalStateException("this cart already opened");
        }

            this.number=number;
            this.customer=customer;

 }
 public synchronized void addItem(String sku, int qty){
        if(qty<1){
            throw new StoreException("invalid quantity ");
        }

        Product product= productService.findBySku(sku);
        if(product.getStockQuantity()==0)throw new OutOfStockException(product.getName()+ " is out of stock ");

        int newQty = qty+ lines.getOrDefault(sku, 0);
        if(maxQuantityPerProduct<newQty){
            throw new StoreException("You can add at most " + maxQuantityPerProduct);
        }
        if(product.getStockQuantity()<newQty){
            throw new OutOfStockException( "only " + product.getStockQuantity() + " available for " + product.getName() );
        }
          lines.put(sku,newQty);
 }

 /*
  --------------الطريقة العادية بدونStream ---------------
    public BigDecimal subtotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<String, Integer> entry : lines.entrySet()) {
            String sku = entry.getKey();
            int qty = entry.getValue();
            total = total.add(productService.getPrice(sku, qty));
        }

        return total;
    }

  */
 public BigDecimal subtotal(){
return lines.entrySet().
        stream().
        map(entry->productService.getPrice(entry.getKey(),entry.getValue()))
        .reduce(Money.ZERO,BigDecimal::add);
 }
 public boolean isEmpty(){
    return lines.isEmpty();

 }
    public void  clear(){
        lines.clear();
    }
    public Map<String,Integer>lines(){
     return  Collections.unmodifiableMap(lines);
    }
    public CartView view(){
        List<LineView>lineViews=new ArrayList<>();
        for (Map.Entry<String, Integer>entry: lines.entrySet()){
            String sku = entry.getKey();
            int qty = entry.getValue();
           Product product= productService.findBySku(sku);
            LineView lineView=new LineView(sku,product.getName(),qty,productService.getPrice(sku,qty));
            lineViews.add(lineView);
        }

                int count =0;
        for(LineView lineView:lineViews){
            count+=lineView.quantity();
        }


        CartView cartView=new CartView(number,customer,List.copyOf(lineViews),count,subtotal(),isEmpty());
        return cartView;
    }
}
