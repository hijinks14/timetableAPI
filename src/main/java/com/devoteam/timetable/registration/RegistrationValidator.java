package com.devoteam.timetable.registration;


import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class RegistrationValidator implements Validator {

    /**
     * This Validator validates *just* Registration instances
     */
    public boolean supports(Class clazz) {
        return Registration.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
    	
    	/* Iedere validator is een aparte check. bij meerdere checks kan je zelf instellen of er een fout gegeven wordt direct bij de eerste check, of pas na alle checks */
    	
        ValidationUtils.rejectIfEmpty(e, "hours", "hours.empty");
        Registration p = (Registration) obj;
        boolean invalidator = false;
        String errorText = "Succes";
        String errorValue = "Succes";
        
        //check for whole or half hour values
        if (p.getHours().toPlainString().matches("\\d+(\\.5)|\\\\d")) {
            invalidator = true;
            errorText = "Hours can only be whole or half values";
            errorValue = "hours";
        }
        
        //check for whole or half hour values
        if (p.getHours().toPlainString().matches("\\d+(\\.5)?")) {
            invalidator = true;
            errorText = "Hours can only be whole or half values";
            errorValue = "hours";
        }
        
        //Error if a validator returned false
        if(invalidator == true) {
        	e.rejectValue(errorValue, errorText);
        }
    }

}