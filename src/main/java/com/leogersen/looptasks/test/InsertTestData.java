package com.leogersen.looptasks.test;

import com.leogersen.looptasks.domain.*;
import com.leogersen.looptasks.task.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.*;

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

        //TODO: Security
        AppUser appUser = new AppUser("john", "123", "John Canvas");
        appUserRepository.save(appUser);


    }
}
