package be.cegeka.rsvz.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = InszConstraintValidator.class)
@Documented
public @interface Insz {
    String message() default "{insz-not-valid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}