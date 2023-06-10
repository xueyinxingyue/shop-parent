package com.xueyin.productserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductServerApp.class,args);
    }
}
