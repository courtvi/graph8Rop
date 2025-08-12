package org.ep.rop.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/welcome")
public class WelcomeController {


    @Autowired
    public WelcomeController() {
    }

    @GetMapping("")
    public String welcome() {
        return "Welcome to the Spring Boot application!";
    }
}

