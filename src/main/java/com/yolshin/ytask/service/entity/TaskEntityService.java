package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.Task;

import java.util.List;

public interface TaskEntityService extends BaseTreeEntityService<Task> {
    List<Task> findAll();
    Task save(Task task);
}
