package com.leogersen.looptasks.task;

import com.leogersen.looptasks.domain.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.*;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "A descrição da tarefa é obrigatória")
    @Length(min = 3, max = 40, message = "O tamanho da tarefa é inválido")
    private String description;

    @NotNull
    @FutureOrPresent(message = "A data da tarefa não pode estar no passado")
    private LocalDate whenToDo;

    private boolean done = false;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    //@NotNull(message = "O usuário da tarefa é obrigatório")
    private AppUser appUser;

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getWhenToDo() {
        return whenToDo;
    }

    public void setWhenToDo(LocalDate whenToDo) {
        this.whenToDo = whenToDo;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Task() {

    }

    public Task(String description, LocalDate whenToDo, boolean done) {
        super();
        this.description = description;
        this.whenToDo = whenToDo;
        this.done = done;
    }
}
