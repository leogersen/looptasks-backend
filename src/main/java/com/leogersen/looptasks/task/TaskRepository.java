package com.leogersen.looptasks.task;

import org.springframework.data.repository.*;

public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {

    Task findByDescription(String description);

}
