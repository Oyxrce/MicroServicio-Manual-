package com.example.manual_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManualServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ManualServiceApplication.class, args);
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" MicroServicio Manual Operativo - Puerto 8081");
        System.out.println(" http://localhost:8081/api/manuales");
        System.out.println("=".repeat(50) + "\n");
    }
}