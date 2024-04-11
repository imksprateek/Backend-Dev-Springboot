package com.ksprateek.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${application.message}")
    private String message;

    @GetMapping(path = "/")
    public String myFun(){
        return message;
    }
}
