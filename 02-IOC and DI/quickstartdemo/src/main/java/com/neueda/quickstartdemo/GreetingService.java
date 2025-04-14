package com.neueda.quickstartdemo;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public String getGreeting() {
        return "Hello from the Greeting Service!";
    }
}
