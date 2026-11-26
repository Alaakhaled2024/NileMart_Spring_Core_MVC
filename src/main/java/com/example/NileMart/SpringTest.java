package com.example.NileMart;

import com.example.NileMart.cart.ShoppingCart;
import com.example.NileMart.config.AppConfig;
import com.example.NileMart.notification.NotificationDemo;
import com.example.NileMart.repository.InMemoryProductRepository;
import com.example.NileMart.service.ProductService;
import com.example.NileMart.shipping.ShippingDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService =
                context.getBean(ProductService.class);

        System.out.println("spring container started successfully ");
        AppConfig appConfig = context.getBean(AppConfig.class);

        System.out.println("Store Name: " + appConfig.getStoreName());
        ShippingDemo D=context.getBean(ShippingDemo.class);
        D.testShipping();
        NotificationDemo notificationDemo=context.getBean(NotificationDemo.class);
        notificationDemo.printNotificationServices();
        ProductService service1 = context.getBean(ProductService.class);
        ProductService service2 = context.getBean(ProductService.class);
         System.out.println(service1==service2);
        ShoppingCart cart1 = context.getBean(ShoppingCart.class);
        ShoppingCart cart2 = context.getBean(ShoppingCart.class);
        System.out.println(cart1==cart2);
        context.close();
    }
}