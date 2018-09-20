package com.devoteam.timetable.HourValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention( RetentionPolicy.RUNTIME )
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = HourFormatValidator.class)
public @interface HourFormat {
    String message() default "Invalid hour format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}