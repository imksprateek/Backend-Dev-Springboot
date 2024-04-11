package com.prateek.springcoredemo;

import org.springframework.stereotype.Component;

//@Component annotation marks a class as bean. This can be injected by Spring as dependency
@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
