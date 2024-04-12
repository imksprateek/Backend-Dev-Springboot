package com.prateek.springcoredemo.rest;

import com.prateek.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //Scope refers to the lifecycle of the bean. How long does the bean live? How many instances are created? How is the bean shared?
    //Default scope in spring is Singleton. That is, Spring Container creates only one instance of the bean by default, it is cached in memory, All dependency injections for the bean will reference the SAME bean.

    //When prototype scope is used, new object instance is created for each injection. So they point to two different areas of memory or two different beans.
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach")Coach theAnotherCoach){
        //So, only one instance is created from CricketCoach and Both theCoach and theAnotherCoach will point to the same instance since the default scope in spring is singleton
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
         this.anotherCoach = theAnotherCoach;
     }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout() + " <----> " + anotherCoach.getDailyWorkout();
    }

    //To perform a check on scope
    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach  == anotherCoach, " + (myCoach == anotherCoach);
    }
    //When scope is singleton, the above returns true and when scope is prototype the above returns false

    //Also notice that when the scope is prototype, the constructor of CricketCoach is executed twice, that means 2 different cricketCoach beans are created
}
