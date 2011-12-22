package be.cegeka.rsvz;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class Child implements Serializable {

    @Digits(integer = 3, fraction = 0, message="{three-digits-numbers}")
    @NotNull
    private Integer id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Digits(integer = 3, fraction = 0, message="{three-digits-numbers}")
    @NotNull
    private Integer age;

    @NotNull
    @Past
    private Date birthdate;

    @Digits(integer = 6, fraction = 2, message="{six-digits-numbers}")
    @NotNull
    private Double pocketMoney;

    public Child() {
    }

    public Child(Integer id, String firstName, String lastName, Integer age, Date birthdate, Double pocketMoney) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthdate = birthdate;
        this.pocketMoney = pocketMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Double getPocketMoney() {
        return pocketMoney;
    }

    public void setPocketMoney(Double pocketMoney) {
        this.pocketMoney = pocketMoney;
    }
}