package com.food.ordering.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class CustomerServApplication {
    public static void main(String[] args) {

        SpringApplication.run(CustomerServApplication.class, args);

    }
}