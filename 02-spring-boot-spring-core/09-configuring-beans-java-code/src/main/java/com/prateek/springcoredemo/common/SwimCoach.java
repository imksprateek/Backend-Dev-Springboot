package com.prateek.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//We don't use @Component annotation here because we have a @Configuration class SportsConfig that configures the bean swimCoach
public class SwimCoach implements Coach{
    public SwimCoach(){
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
        return "Swim a 1000 m as warm up :-)";
    }

}
