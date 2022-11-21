package demo8;

public class Person {
    private String name;
    private char sex;
    private String id;
    private String phone;
    private String email;

    public Person(String name, char sex, String id) {
        this.name = name;
        this.sex = sex;
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
