package com.example.task3app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Products & Review Management", version = "1.0"))
public class Task3AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Task3AppApplication.class, args);
    }

}
