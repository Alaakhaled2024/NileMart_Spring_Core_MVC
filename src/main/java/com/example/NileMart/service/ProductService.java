package com.example.NileMart.service;

import com.example.NileMart.Pricing.PricingService;
import com.example.NileMart.common.StoreException;
import com.example.NileMart.model.Category;
import com.example.NileMart.model.Product;
import com.example.NileMart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
@Service
public class ProductService {
    ProductRepository productRepository ;
    PricingService pricingService ;
    public ProductService(ProductRepository productRepository,PricingService pricingService){
        this.productRepository=productRepository;
        this.pricingService=pricingService;
    }

    public List<Product> findAll(){
    List<Product> listOfProduct = new ArrayList<>(productRepository.findAll());
        listOfProduct.sort(Comparator.comparing(Product::getCategory).thenComparing(Product::getName));
        return listOfProduct;
    }

   public Product findBySku(String sku){

      return productRepository.findBySku(sku).orElseThrow(()->new StoreException(" Not found "));

   }
   public  BigDecimal getPrice(String sku, int quantity){
        Product product = findBySku(sku);
     return   pricingService.getPrice(product,quantity);
   }
   public void reduceStock(String sku, int quantity) {
        if (quantity > 0) {
            Product product = findBySku(sku);
            if (product.getStockQuantity() >= quantity) {
                int past = product.getStockQuantity();
                int updatedStock = past - quantity;
                product.setStockQuantity(updatedStock);
                productRepository.save(product);
            } else throw new StoreException("quantity greater than our stock");
        }else  throw new StoreException("Quantity NOT Valid");
    }
   public List <Product> search(Predicate<Product>predicate){
        List<Product>productList=new ArrayList<>();
        for(Product product: findAll()){
            if(predicate.test(product)){
                productList.add(product);
            }
        }
        return productList;
   }
   public Map<Category,List<Product>>groupByCategory(){
       Map<Category,List<Product>>productMap=new HashMap<>();
       for(Product product:findAll()){
           if (!(productMap.containsKey(product.getCategory()))){
               productMap.put(product.getCategory(),new ArrayList<>());
               productMap.get(product.getCategory()).add(product);

           }
           else {
               productMap.get(product.getCategory()).add(product);
           }
       }
       return productMap;
   }
}
