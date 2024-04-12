package com.prateek.springcoredemo.common;

import com.prateek.springcoredemo.common.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//We can also explicitly specify the bean scope using @Scope annotation
//The below line makes the scope singleton explicitly (it is already singleton by default in spring)
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE will create a new bean instance for each container request.
//request scope is scoped to an HTTP web request. Only used for web apps
//session scope is scoped to an HTTP web session; Only used for web apps
//global-session scope is scoped to a global HTTP web session; Only used for web apps
@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-)";
    }
}
