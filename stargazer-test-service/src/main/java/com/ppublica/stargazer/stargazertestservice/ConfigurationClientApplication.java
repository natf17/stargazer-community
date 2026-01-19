package com.ppublica.stargazer.stargazertestservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
public class ConfigurationClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationClientApplication.class);
    }
}

@RequestScope
@RestController
class MessageRestController {
    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}
