package com.myweather.myweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.myweather.myweather")
public class MyweatherApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MyweatherApplication.class, args);
    }

}
