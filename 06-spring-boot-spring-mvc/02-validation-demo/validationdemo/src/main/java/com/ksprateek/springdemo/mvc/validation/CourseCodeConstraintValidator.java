package com.ksprateek.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

//    Initializing coursePrefix value
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

//    Custom business logic to return true or false when the annotated field validates
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if(theCode != null){
            result = theCode.startsWith(coursePrefix);
        }else {
            result = true;
        }

        return result;
    }
}
