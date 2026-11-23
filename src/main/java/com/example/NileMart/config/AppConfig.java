package com.example.NileMart.config;

import com.example.NileMart.repository.InMemoryProductRepository;
import com.example.NileMart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example.NileMart")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${store.name}")
    private String storeName;
    public String getStoreName(){
        return storeName;
    }
    @Bean
    public ProductRepository productRepository(){
        return new InMemoryProductRepository();
    }
}

