package com.rest.jpa.curdOperations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurdOperationController {

    @GetMapping("/")
    public String healthCheck() {
        return "Up and Running Successfully";
    }

}
