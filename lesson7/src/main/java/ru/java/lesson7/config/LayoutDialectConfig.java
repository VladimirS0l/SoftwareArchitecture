package ru.java.lesson7.config;


import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LayoutDialectConfig {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect(null, false);
    }
}
