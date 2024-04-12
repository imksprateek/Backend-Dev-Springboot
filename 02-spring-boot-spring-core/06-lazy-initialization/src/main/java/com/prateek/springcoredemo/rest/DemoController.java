package com.prateek.springcoredemo.rest;

import com.prateek.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for dependency
    private Coach myCoach;

//By default spring initializes all the beans for dependency injection.
//When @Lazy annotation is used, trackCoach bean will only be initialized if needed for dependency injection.

//since TrackCoach class has annotation @Lazy, you can see in the output trackCoach bean is not initialized. It will be only initialized when it is required for dependency injection or unless specified
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
        //We specify the bean name in @Qualifier annotation
        //Note that the class name is TennisCoach but the bean name will be tennisCoach. Same with other coach implementations.
        //But when we use trackCoach bean here, we specify that it is to be injected. So the trackCoach bean will be initialized even though it's marked with @Lazy annotation
         this.myCoach = theCoach;
         System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //To configure other beans for lazy initialization we would need to add @Lazy to each class. It is a tedious work for large number of classes. Hence there is a way to set a global configuration property for this. We do it in application.properties file
    //In this case, for dependency resolution Spring creates an instance of TennisCoach first.. Then creates instance of DemoController and injects the CricketCoach. To demonstrate this, we've added println statements in constructors of coach implementation classes

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
