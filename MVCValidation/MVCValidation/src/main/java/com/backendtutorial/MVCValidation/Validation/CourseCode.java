package com.backendtutorial.MVCValidation.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeValidator.class)
@Target({ElementType.FIELD , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define value for annotaion
    public String value() default "LUV";

    //define error message
    public String message() default "start with LUV";

    //define group
    public Class<?>[] groups() default {};

    //define payload
    public Class<? extends Payload>[] payload() default {};
}
