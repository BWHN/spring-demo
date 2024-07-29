package org.example.config;

import org.example.bean.Bean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }
}
