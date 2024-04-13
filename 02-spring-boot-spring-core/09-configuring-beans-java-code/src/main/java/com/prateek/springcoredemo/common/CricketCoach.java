package com.prateek.springcoredemo.common;

import com.prateek.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component annotation marks a class as bean. This can be injected by Spring as dependency
@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //Define our init method
    //@PostConstruct annotation is used to add our own custom initialization code once the bean has been constructed
//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
//    }
//
//    //define our destroy method
//    //@PreDestroy allows us to add our own custom logic for the cleanup work (When the application is stopped)
//    @PreDestroy
//    public void doMyCleanupStuff(){
//        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-)";
    }
}
