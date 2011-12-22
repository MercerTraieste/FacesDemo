package be.cegeka.rsvz.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InszConstraintValidator implements ConstraintValidator<Insz, String> {

    public void initialize(Insz constraintAnnotation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{
            Integer.parseInt(value);
        }catch(NumberFormatException ex){
            return false;
        }

        return true;
    }
}