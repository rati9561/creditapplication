package com.shreeganeshfinance.creditapplication.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UserNameValidator implements ConstraintValidator<ValidUserName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.length() > 3 && value.length()<21) {
            return true;
        }else{
            return false;
        }
    }

    
    
    
}
