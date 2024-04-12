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

    //You can add custom code during bean initialization like setting up handles to resources (db, sockets, file, etc)
    //You can add custom code during bean destruction like Clean up handles to resources (db, sockets, files, etc)

    //@PostConstruct annotation is used for custom code during bean initialization (init method configuration)
    //@PreDestroy annotation is used for custom code during bean destruction (Destroy method configuration)


    //Development process -
    //1. Define your methods for init and destroy in the class CricketCoach
    //2. Add annotations @PostConstruct and @PreDestroy for those methods
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        this.myCoach = theCoach;
         System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
