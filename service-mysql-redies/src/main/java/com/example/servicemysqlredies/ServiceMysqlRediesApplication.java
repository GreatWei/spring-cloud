package com.example.servicemysqlredies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ServiceMysqlRediesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMysqlRediesApplication.class, args);
    }
}
