package be.cegeka.rsvz;

public class Child {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String sex;
    
    public Child() {

    }

    public Child(Integer id, String firstName, String lastName, Integer age, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (age != null ? !age.equals(child.age) : child.age != null) return false;
        if (firstName != null ? !firstName.equals(child.firstName) : child.firstName != null) return false;
        if (id != null ? !id.equals(child.id) : child.id != null) return false;
        if (lastName != null ? !lastName.equals(child.lastName) : child.lastName != null) return false;
        if (sex != null ? !sex.equals(child.sex) : child.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}