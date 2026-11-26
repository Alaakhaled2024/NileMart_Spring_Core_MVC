package com.example.NileMart.repository;

import com.example.NileMart.common.StoreException;
import com.example.NileMart.model.Category;
import com.example.NileMart.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProductRepository implements ProductRepository {


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
    @PostConstruct
    public void loadCatalog() {
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream("products.csv");
        if (inputStream==null) {
            throw new StoreException(
                    "The catalog could not be loaded ",
                    new FileNotFoundException("products.csv was not found.")
            );}
        try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream))){
        String header = bufferedReader.readLine();
        String line;
            int count=0 ;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            Category category = Category.valueOf(parts[2]);
            BigDecimal price = new BigDecimal(parts[3]);
            int stock = Integer.parseInt(parts[4]);
            Product product = new Product(parts[0], parts[1], category, price, stock);
            productList.put(product.getSku(), product);
            count++;
        }System.out.println(" Catalog loaded : " + count + " products");
        }catch (IOException e) {
            throw new StoreException(" The catalog could not be loaded", e);
        }
    }


    @PreDestroy
    public void closeCatalog() {
        System.out.println("Catalog closed");
    }

}


