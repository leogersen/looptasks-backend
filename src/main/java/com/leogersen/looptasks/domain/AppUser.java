package com.leogersen.looptasks.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "app_user")
public class AppUser {

    public AppUser() {
    }

    public AppUser(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "O nome de usuário é obrigatório")
    private String username;

    @NotEmpty(message = "O nome de exibição é obrigatório")
    private String password;

    @NotEmpty(message = "O nome de exibição é obrigatório")
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
