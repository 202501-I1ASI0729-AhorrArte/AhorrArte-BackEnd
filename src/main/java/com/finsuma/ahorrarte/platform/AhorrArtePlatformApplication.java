package com.finsuma.ahorrarte.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.finsuma.ahorrarte", "com.FinSuma.AhorrArte"})
@EntityScan(basePackages = {"com.finsuma.ahorrarte", "com.FinSuma.AhorrArte"})
@EnableJpaRepositories(basePackages = {"com.finsuma.ahorrarte", "com.FinSuma.AhorrArte"})
public class AhorrArtePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(AhorrArtePlatformApplication.class, args);
    }

}
