package com.pepeni.springboot.cpudiff.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String email;
    private String nick;
    private String password;

    public User(String email, String nick, String password) {
        this.email = email;
        this.nick = nick;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
