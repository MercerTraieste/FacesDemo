package be.cegeka.rsvz.faces.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;


@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    private static final String EMAIL = "gigel.sparge@lemne.com";
    private static final String RESOURCE_BUNDLE_VAR_NAME = "text";


    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o != null && EMAIL.equals(o.toString())) {
            FacesMessage msg = new FacesMessage(getResourceBundleString("email-already-exists"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public String getResourceBundleString(String resourceKey) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, RESOURCE_BUNDLE_VAR_NAME);
        return bundle.getString(resourceKey);
    }
}
