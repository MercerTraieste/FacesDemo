package be.cegeka.rsvz.faces.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.print.attribute.standard.Severity;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator{

    private static final String EMAIL ="gigel.sparge@lemne.com";

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if(o!= null && EMAIL.equals(o.toString())) {
            FacesMessage msg = new FacesMessage("Email validation failed. This address already exists.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
