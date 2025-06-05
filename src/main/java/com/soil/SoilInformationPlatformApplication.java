package com.soil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.soil.mapper")
public class SoilInformationPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoilInformationPlatformApplication.class, args);
    }
} 