package org.lion.cloud.provider12301;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Provider12302Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider12302Application.class, args);
    }
}
