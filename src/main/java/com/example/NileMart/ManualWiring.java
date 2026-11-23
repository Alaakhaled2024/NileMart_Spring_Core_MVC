package com.example.NileMart;

import com.example.NileMart.Pricing.PromotionalPricingService;
import com.example.NileMart.Pricing.StandardPricingService;
import com.example.NileMart.common.StoreException;
import com.example.NileMart.model.Category;
import com.example.NileMart.model.Product;
import com.example.NileMart.repository.InMemoryProductRepository;
import com.example.NileMart.service.ProductService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class ManualWiring {
    InMemoryProductRepository inMemoryProductRepository =new InMemoryProductRepository();
    StandardPricingService standardPricingService = new StandardPricingService();
    PromotionalPricingService promotionalPricingService =new PromotionalPricingService();
    ProductService productService=new ProductService( inMemoryProductRepository,promotionalPricingService);
    public static void main(String[] args) {

        ManualWiring app = new ManualWiring();

     //   System.out.println(app.productService.getPrice("ACC-CHG-20W", 2));

        List<Product> outOfStockProducts = app.productService.search(product -> product.getStockQuantity() == 0);
      //  System.out.println(outOfStockProducts);


        Map<Category, List<Product>> productsByCategory = app.productService.groupByCategory();
        //  System.out.println(productsByCategory);
        app.productService.reduceStock("PH-X5-128",3);
       // System.out.println(app.productService.findBySku("PH-X5-128").getStockQuantity());

        try{ app.productService.reduceStock("HOM-PAN-28",6);}
        catch (StoreException e){

            System.out.println( e.getMessage());
        }
        // 0 value ---> message in console ----> Quantity NOT Valid
        // value greater than 5 ---> message in console ---->quantity greater than our stock
        //negative value ---> message in console ----> Quantity NOT Valid
        System.out.println( app.productService.findBySku("HOM-PAN-28").getStockQuantity());
        try {
            app.productService.findBySku("Alaa-2006");
        }catch (StoreException e){
            System.out.println(e.getMessage());
        }

        Set<Product>productSet=new HashSet<>();
        Product p1=app.productService.findBySku("PH-X5-128");
        Product p2=app.productService.findBySku("PH-X5-128");
        productSet.add(p1);
        productSet.add(p2);
        //System.out.println(productSet);
       // System.out.println(productSet.size());
        Product p3=new Product("PH-X5-128", "Another Smartphone", Category.ELECTRONICS,
                new BigDecimal("100"), 5);
        productSet.add(p3);
        System.out.println(productSet);
        System.out.println(productSet.size());

    }
    }

