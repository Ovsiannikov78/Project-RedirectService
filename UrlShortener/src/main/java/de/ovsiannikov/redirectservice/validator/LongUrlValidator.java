package de.ovsiannikov.redirectservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LongUrlValidator implements ConstraintValidator<LongUrlConstraint, String> {

    @Override
    public void initialize(LongUrlConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String longUrl, ConstraintValidatorContext constraintValidatorContext) {

        return !longUrl.contains(" ");
    }
}
