package com.wow.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan("com.wow")
@EnableConfigurationProperties
@SpringBootApplication
public class WowApplication {
    public static void main(String[] args) {
        SpringApplication.run(WowApplication.class, args);
    }
}
