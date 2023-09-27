package ir.maktab101.hw08.domain;

import ir.maktab101.hw08.base.domain.BaseEntity;

public class User extends BaseEntity {
    public static final String TABLE_NAME = "user_tbl";

    public static final String FULL_NAME = "full_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    private String fullName;
    private String userName;
    private String password;
    private String email;
    public User(){

    }
    public User(String fullName, String userName, String password, String email) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String fullName, String userName, String password, String email) {
        super(id);
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
