package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.Task;
import com.yolshin.ytask.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends BaseTreeEntityServiceImpl<Task> implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
