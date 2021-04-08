package de.ovsiannikov.redirectservice.validator;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UrlsValidator implements ConstraintValidator<UrlConstraint, String> {

    private final UrlValidator validator = new UrlValidator(new String[]{"http", "https"});

    @Override
    public void initialize(UrlConstraint url) {
    }

    @Override
    public boolean isValid(String url,
                           ConstraintValidatorContext context) {
        return url != null && validator.isValid(url);
    }
}
