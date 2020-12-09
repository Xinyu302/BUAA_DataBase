package com.yxy.market1.entity.dto.form;

public class UserLoginForm {
    private String username;

    private String password;

//    private String rememberme;

    public UserLoginForm() {
    }

    public UserLoginForm(String username, String password, String rememberme) {
        this.username = username;
        this.password = password;
//        this.rememberme = rememberme;
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

//    public String getRememberme() {
//        return rememberme;
//    }
//
//    public void setRememberme(String rememberme) {
//        this.rememberme = rememberme;
//    }
}
