package com.example.servicemysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class ServiceMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMysqlApplication.class, args);
    }
}
