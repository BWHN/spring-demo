package org.example.config;

import org.example.bean.Bean1;
import org.example.bean.Bean2;
import org.example.bean.Bean3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }
    @Bean
    public Bean2 bean2() {
        return new Bean2();
    }
    @Bean
    public Bean3 bean3() {
        return new Bean3();
    }
}
