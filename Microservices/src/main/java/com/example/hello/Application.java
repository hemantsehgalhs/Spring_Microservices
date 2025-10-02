package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot entry point for the Microservices application.
 */
@SpringBootApplication
public class Application {
    /**
     * Bootstraps the Spring application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    /**
     * Minimal hello endpoint to verify the application starts.
     */
    static class HelloController {
        @GetMapping("/")
        /**
         * Returns a basic liveness string.
         *
         * @return greeting text
         */
        public String hello() {
            return "Hello, World";
        }
    }
}
