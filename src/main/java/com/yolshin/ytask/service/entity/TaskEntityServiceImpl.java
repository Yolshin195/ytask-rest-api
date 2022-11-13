package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.Task;
import com.yolshin.ytask.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskEntityServiceImpl extends BaseTreeEntityServiceImpl<Task> implements TaskEntityService {

    protected final TaskRepository repository;

    public TaskEntityServiceImpl(TaskRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
