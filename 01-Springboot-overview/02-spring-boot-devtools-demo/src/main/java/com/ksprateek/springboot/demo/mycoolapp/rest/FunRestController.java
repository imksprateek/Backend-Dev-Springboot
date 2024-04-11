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

    //expose a new endpoint for "workout"
    @GetMapping(path="/workout")
    public String getDailyWorkout(){
        return "Stay Hard folks!";
    }

    @GetMapping(path="/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day mann. Congrats!";
    }
}
