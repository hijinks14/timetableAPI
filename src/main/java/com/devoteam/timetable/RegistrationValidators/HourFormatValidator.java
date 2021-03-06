package com.devoteam.timetable.RegistrationValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HourFormatValidator implements ConstraintValidator<HourFormat, Double> {

	@Override
    public void initialize(HourFormat annotation) {
        // no-op - no initialization needed
    }

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if (value  == null) {
			return true;
		}
		
		if (value  % 0.5 != 0) {
			return false;
		}

		// Validation succeeded!
		return true;
	}
}
