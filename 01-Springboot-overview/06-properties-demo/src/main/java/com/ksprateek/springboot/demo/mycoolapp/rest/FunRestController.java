package com.ksprateek.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${application.message}")
    private String message;

    @Value("${team.name}")
    private String team;

    @Value("${coach.name}")
    private String coach;

    //    Expose new endpoint for "teaminfo"
    @GetMapping(path="/teaminfo")
    public String getTeamInfo(){
        return "coach: " + coach + ", Team: " + team;
    }

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
