package ro.mindit.forum.domain;

import java.io.Serializable;

/**
 * User domain class
 *
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
public class User implements Serializable {

    private int id;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String dob;
    private String sex;
    private String city;
    private String registerDate;
    private int user_role_id;


    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;

    }

    public User(int id, String userName, String email, String password, String firstName, String lastName, String dob, String sex, String city, String registerDate, int user_role_id) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        this.city = city;
        this.registerDate = registerDate;
        this.user_role_id = user_role_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
