package com.neueda.quickstartdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanExample {

@Bean
    public PasswordGenerator getPasswordGenerator() {
        return new SecurePasswordGenerator(true);
    }
}
