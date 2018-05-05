package com.example.serviceeurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEurekaClientApplication.class, args);
    }
}
