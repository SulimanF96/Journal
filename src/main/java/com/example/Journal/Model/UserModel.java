package com.example.Journal.Model;

import com.example.Journal.data.Privilege;

import java.util.List;

public class UserModel
{
    private String username;

    private String mobileNumber;

    private String password;

    private String email;


    public UserModel(String username, String mobileNumber, String password, String email) {
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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
