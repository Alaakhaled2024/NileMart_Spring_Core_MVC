package com.example.NileMart.repository;

import com.example.NileMart.common.StoreException;
import com.example.NileMart.model.Category;
import com.example.NileMart.model.Product;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProductRepository implements ProductRepository {
    public InMemoryProductRepository() {
        loadSeedProducts();
    }

    ConcurrentHashMap<String,Product> productList=new ConcurrentHashMap<String,Product>();
    @Override
    public List<Product> findAll(){
       return List.copyOf( productList.values()) ;
        }


   @Override
   public  Optional<Product> findById (String sku){
        if(productList.containsKey(sku)){
         return Optional.of(productList.get(sku))   ;
        }
        return Optional.empty();


   }

   @Override
   public  Product save(Product p){
       String sku= p.getSku();

       productList.put(sku,p);
       return p ;
   }

   public void loadSeedProducts(){
       productList.put("PH-X5-128",new Product("PH-X5-128","Smartphone X5 128GB"
               , Category.ELECTRONICS,new BigDecimal("16000.00"),12));
       productList.put("ACC-CHG-20W",new Product("ACC-CHG-20W","Fast Charger 20W"
               , Category.ELECTRONICS,new BigDecimal("650.00"),40));
       productList.put("ACC-BUDS-6",new Product("ACC-BUDS-6","Wireless Earbuds"
               , Category.ELECTRONICS,new BigDecimal("1100.00"),8));
       productList.put("FSH-GAL-001",new Product("FSH-GAL-001","Cotton Galabeya"
               , Category.FASHION,new BigDecimal("900.00"), 25));
       productList.put("HOM-PAN-28",new Product("HOM-PAN-28","Non-stick Frying Pan 28cm"
               , Category.HOME_KITCHEN,new BigDecimal("1200.00"),  3));
       productList.put("HOM-SPC-RCK",new Product("HOM-SPC-RCK","Wooden Spice Rack"
               , Category.HOME_KITCHEN,new BigDecimal("750.00"),   10));
       productList.put("BTY-SUN-50",new Product("BTY-SUN-50","Sun Cream SPF50"
               , Category.BEAUTY,new BigDecimal("350.00"),  0));
       productList.put("BK-CAI-TRI",new Product("BK-CAI-TRI","The Cairo Trilogy"
               , Category.BOOKS,new BigDecimal("450.00"),  15));
   }


}


