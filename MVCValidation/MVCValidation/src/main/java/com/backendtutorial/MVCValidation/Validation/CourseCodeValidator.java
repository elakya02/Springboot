package com.backendtutorial.MVCValidation.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<CourseCode , String> {

    private String coursePrefix;
    @Override
    public void initialize(CourseCode theCode) {
        coursePrefix = theCode.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if(s!=null)
        {
            result = s.startsWith(coursePrefix);
        }
        else
        {
            return true;
        }
        return result;
    }
}
