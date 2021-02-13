package com.leogersen.looptasks.test;

import com.leogersen.looptasks.domain.*;
import com.leogersen.looptasks.task.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.event.*;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;

import java.time.LocalDate;

@Component
public class InsertTestData {

    private TaskRepository taskRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    public InsertTestData(TaskRepository taskRepository, AppUserRepository appUserRepository) {
        this.taskRepository = taskRepository;
        this.appUserRepository = appUserRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        AppUser appUser1 = new AppUser("john", encoder.encode("123"), "John Canvas");
        appUserRepository.save(appUser1);

        AppUser appUser2 = new AppUser("Paul", encoder.encode("123"), "Paul Canvas");
        appUserRepository.save(appUser2);


        LocalDate baseDate = LocalDate.parse("2025-02-01");

        for (int i = 1; i <= 5; i++) {
            Task task = new Task(String.format("Tarefa do %s #%d", appUser1.getUsername(), i), baseDate.plusDays(i), false);
            task.setAppUser(appUser1);
            taskRepository.save(task);

        }

        for (int i = 1; i <= 5; i++) {
            Task task = new Task(String.format("Tarefa do %s #%d", appUser2.getUsername(), i), baseDate.plusDays(i), false);
            task.setAppUser(appUser2);
            taskRepository.save(task);

        }


    }
}
