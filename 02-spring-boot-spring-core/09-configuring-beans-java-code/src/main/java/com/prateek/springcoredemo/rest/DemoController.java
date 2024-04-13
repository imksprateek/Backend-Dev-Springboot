package com.prateek.springcoredemo.rest;

import com.prateek.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //Bean lifecycle looks like this-
    //Spring Container started -> Bean Instantiated -> Dependencies Injected -> Internal Spring Processing -> Your Custom Init Method -> Bean is Ready for use -> When the container is shut down -> Your Custom Destroy Method
    private Coach myCoach;

    //Without SportsConfig file, swimCoach class without @Component will not inject a bean
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach){
        this.myCoach = theCoach;
         System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
