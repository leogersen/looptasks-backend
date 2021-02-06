package com.leogersen.looptasks.domain;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class AppUser {

    public AppUser() {
    }

    public AppUser(Integer id, String username, String password, String displayName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    private String displayName;

    public Integer getId() {
        return id;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
