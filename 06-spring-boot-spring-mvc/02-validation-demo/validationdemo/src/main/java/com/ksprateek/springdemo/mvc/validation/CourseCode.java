package com.ksprateek.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Specify the ConstraintValidator class that validates the annotated fields
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//Specify where this annotation can be used, for methods or for fields, etc
@Target({ElementType.METHOD, ElementType.FIELD})
//Retain this annotation in the compiled bytecode
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
//    Define default course code
    public String value() default "LUV";

//    Define default error message for people who are using this annotation
    public String message() default "must start with LUV";


//    Define default groups. We're not using any grouping constaints here. So give an empty collection
    public Class<?>[] groups() default {};

//    Define default payloads. Payloads give additional information about the error message
    public Class<? extends Payload>[] payload() default {};
}
