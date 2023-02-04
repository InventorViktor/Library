package com.cartoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cartoon")
@EnableJpaRepositories
public class CartoonWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartoonWebApplication.class, args);
    }

}
