package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@SpringBootApplication
public class RatingServiceApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RatingServiceApplication.class);
        app.run(args);
    }
}
