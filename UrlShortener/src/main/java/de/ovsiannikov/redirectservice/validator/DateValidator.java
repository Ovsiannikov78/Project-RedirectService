package de.ovsiannikov.redirectservice.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

@Component
public class DateValidator implements ConstraintValidator<DateConstraint, LocalDateTime> {

    @Override
    public void initialize(DateConstraint date) {
    }

    @Override
    public boolean isValid(LocalDateTime date, ConstraintValidatorContext context) {

        return date.isAfter(LocalDateTime.now());
    }
}
