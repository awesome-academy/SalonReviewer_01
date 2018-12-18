package com.framgia.gotosalon.data.model;

public class Account {
    private String mEmail;
    private String mPassword;

    public Account() {

    }

    public Account(String email, String password) {

        mEmail = email;
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
