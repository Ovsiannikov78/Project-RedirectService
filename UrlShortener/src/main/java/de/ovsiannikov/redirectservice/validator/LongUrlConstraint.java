package de.ovsiannikov.redirectservice.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LongUrlValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LongUrlConstraint {

    String message() default "Invalid url. Url must not contain white spaces.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
