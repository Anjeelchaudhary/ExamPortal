package com.exam.models;

public class JwtRequest {
    String username;
    String passowrd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public JwtRequest() {
    }

    public JwtRequest(String username, String passowrd) {
        this.username = username;
        this.passowrd = passowrd;
    }
}
