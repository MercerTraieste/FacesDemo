package be.cegeka.rsvz;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.richfaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class FormBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;

    @Size(min = 10, max = 10, message = "{ten-digits}")
    @Pattern(regexp = "^([0-9]*)$", message = "{only-numbers}")
    @NotEmpty
    private String insz;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    @Past
    private Date birthdate;

    private Boolean married;

    private String streetName;

    private String streetNumber;

    private List<String> cities;

    private String city;

    private UploadedFile document;

    private Double income;

    private Message message;

    private String kbo;

    @NotNull
    @Email
    private String email;

    public FormBean() {
        cities = Arrays.asList(new String[] {"Bucharest", "Brussels", "Leuven", "Targoviste", "Constanta", "Miami"});
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInsz() {
        return insz;
    }

    public void setInsz(String insz) {
        this.insz = insz;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public UploadedFile getDocument() {
        return document;
    }

    public void setDocument(UploadedFile document) {
        this.document = document;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message[] getMessages() {
        return Message.values();
    }

    public String getKbo() {
        return kbo;
    }

    public void setKbo(String kbo) {
        this.kbo = kbo;
    }
}
