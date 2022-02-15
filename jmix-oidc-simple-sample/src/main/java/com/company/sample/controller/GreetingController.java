package com.company.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/authenticated-hello")
    public String authenticatedHello() {
        return "authenticated-hello";
    }

    @GetMapping("/anonymous-hello")
    public String anonymousHello() {
        return "anonymous-hello";
    }
}
