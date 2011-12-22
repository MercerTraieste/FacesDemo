package be.cegeka.rsvz.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InszConstraintValidator implements ConstraintValidator<Insz, String> {

    public void initialize(Insz constraintAnnotation) {
        // nothing to do here, we don't accept parameters
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return inszCanBeEmpty(value) || (!inszShouldHaveThirteenCharacters(value) && !inszShouldContainOnlyNumbers(value));
    }

    private boolean inszCanBeEmpty(String value) {
        return value.isEmpty();
    }

    private boolean inszShouldContainOnlyNumbers(String value) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }

    private boolean inszShouldHaveThirteenCharacters(String value) {
        return value.length() != 11;
    }
}