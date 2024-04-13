package com.prateek.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//By default spring initializes all the beans for dependency injection.
//When @Lazy annotation is used, trackCoach bean will only be initialized if needed for dependency injection.
@Lazy
@Component
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k :-)";
    }
}
