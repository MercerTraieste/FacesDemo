package be.cegeka.rsvz.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

@FacesValidator("uniqueEmail")
public class UniqueEmail implements Validator {
    private static final String EMAIL = "vali@cegeka.be";

    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {

        if (value.toString().equals(EMAIL)) {
             ResourceBundle bundle = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(),
            "msgs2");
            FacesMessage m = new FacesMessage(bundle.getString("must-not-be-empty"));
            throw new ValidatorException(m);
        }
    }
}
