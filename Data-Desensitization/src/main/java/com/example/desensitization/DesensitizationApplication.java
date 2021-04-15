package com.example.desensitization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.desensitization.com.lf.demo.*"})
public class DesensitizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesensitizationApplication.class, args);
    }

}
