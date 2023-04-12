package com.example.enoca5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example.enoca5"})
public class Enoca5Application {
    public static void main(String[] args) {
        SpringApplication.run(Enoca5Application.class, args);
    }

}
