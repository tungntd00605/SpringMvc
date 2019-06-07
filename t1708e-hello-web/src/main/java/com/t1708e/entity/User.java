package com.t1708e.entity;

public class User {
    private String username;
    private String password;
    private String salt;
    private String fullName;
    private String email;
    private String phone;
    private int status;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String salt, String fullName, String email, String phone) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status = Status.DEACTIVE.getValue();
    }

    public User(String username, String password, String salt, String fullName, String email, String phone, int status) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if(status == null){
            status = Status.DEACTIVE;
        }
        this.status = status.getValue();
    }

    public enum Status{
        ACTIVE(1), DEACTIVE(0), DELETED(-1);

        int value;

        Status(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status findByValue(int value){
            for (Status s : Status.values()){
                if(s.getValue() == value){
                    return s;
                }
            }
            return null;
        }
    }
}
