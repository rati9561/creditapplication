package com.shreeganeshfinance.creditapplication.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserNameValidator.class)
public @interface ValidUserName {

    public String message() default "The user already exists.";

    Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
