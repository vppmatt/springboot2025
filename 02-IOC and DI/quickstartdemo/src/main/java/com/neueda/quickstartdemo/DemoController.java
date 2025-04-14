package com.neueda.quickstartdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @Autowired
    GreetingService greetingService;

    @GetMapping()
    public String helloWorld() {
        return greetingService.getGreeting();
    }
}
