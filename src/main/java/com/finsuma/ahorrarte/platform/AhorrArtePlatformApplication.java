package com.finsuma.ahorrarte.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.finsuma.ahorrarte", "com.FinSuma.AhorrArte"})
public class AhorrArtePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(AhorrArtePlatformApplication.class, args);
    }

}
