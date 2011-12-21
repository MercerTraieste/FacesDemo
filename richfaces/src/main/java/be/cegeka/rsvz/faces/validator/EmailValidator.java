package be.cegeka.rsvz.faces.validator;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Scope;
import java.util.ResourceBundle;


@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    private static final String EMAIL = "gigel.sparge@lemne.com";


    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        ResourceBundle bundle = ResourceBundle.getBundle("be.cegeka.rsvz.faces.i18n.messages", facesContext.getViewRoot().getLocale());
        if (o != null && EMAIL.equals(o.toString())) {
            FacesMessage msg = new FacesMessage(bundle.getString("email-already-exists"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
