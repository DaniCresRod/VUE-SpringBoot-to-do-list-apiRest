package com.example.first.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.first.api.models")
@ComponentScan({"com.example.first.api.controllers", "com.example.first.api.services"})
public class mainClass {
    public static void main(String[] args) {
        SpringApplication.run(mainClass.class, args);
    }
}
