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

    //Constructor injection is used for required dependencies, setter injector is used for optional dependencies
    //Constructor injection is recommended by the spring development team
    //Field Injection was used alot earlier in legacy applications but it is not recommended now, since it makes the code harder to Unit test.
    //Define a setter for dependency injection type - setter injection
    // @Autowired annotation tells Spring to inject a dependency. If you only have one constructor then @Autowired is optional

    //@Qualifer annotation is used to select a bean for injection when there are multiple beans that implement Coach interface. Otherwise spring will not know what dependency  to inject and result in an error.
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
        this.myCoach = theCoach;
    }

    //So, by using a spring object factory speing container, we can actually configure how we want to use a given bean and how we want to use a bean.

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
