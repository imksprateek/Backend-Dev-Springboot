package com.prateek.springcoredemo.config;

import com.prateek.springcoredemo.common.Coach;
import com.prateek.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//To configure the bean we use @Configuration annotation
@Configuration
public class SportConfig {
    //@Bean annotation is used to make an existing third party class available to Spring framework. You may not have access to the source code of third party class However, you would like to use the third party class as a Spring bean
    //For example classes that come with a jar file like S3 in AWS SDK, we can't modify the AWS S3 source code but we can configure it as Spring bean using @Bean annotation
    //So we can configure S3 region, credentials and build our own version of the bean and inject it to the REST controller using @Autowired annotation

    //Here's the summary-
    //- We could use the Amazon S3 Client in our Spring application
    //- The Amazon S3 Client class was not originally annotated with @Component
    //- However, we configured the S3 client as a spring bean using @Bean
    //- It is now a spring bean and we can inject it to other services in our application
    // Thereby we make an existing third-party class available to spring framework
    // The whole point of @Bean is to Take existing third-party class and expose as a Spring bean

    //To give a custom bean id, use @Bean("aquatic") to make the bean id aquatic
    //Also remember to change the injected bean @Qualifier name to aquatic, otherwise the application fails to start
    @Bean
    public Coach swimCoach(){
        //Bean id is the method name by default. So in this case swimCoach
        return new SwimCoach();
    }
}
