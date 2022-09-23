package com.dh.serieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SerieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerieServiceApplication.class, args);
    }

}
