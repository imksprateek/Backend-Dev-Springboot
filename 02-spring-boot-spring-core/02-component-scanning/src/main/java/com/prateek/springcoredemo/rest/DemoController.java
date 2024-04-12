package com.prateek.springcoredemo.rest;

import com.prateek.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for dependency
    private Coach myCoach;

    //Define a constructor for dependency injection
    // @Autowired annotation tells Spring to inject a dependency. If you only have one constructor then @Autowired is optional
    @Autowired
    public DemoController(Coach theCoach){
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
