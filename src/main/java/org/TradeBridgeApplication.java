package org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {
        "org.controllers",
        "org.services",
        "org.data",
        "org.utils",
        "org.exceptions",
        "org.config",

})
public class TradeBridgeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeBridgeApplication.class, args);
    }

}

