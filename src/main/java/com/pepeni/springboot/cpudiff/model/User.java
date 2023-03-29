package com.pepeni.springboot.cpudiff.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    @Column(length = 50, nullable = false, unique = true)
    private String nick;
    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String email, String nick, String password) {
        this.email = email;
        this.nick = nick;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
