package com.yolshin.ytask.service;

import com.yolshin.ytask.model.dto.SimpleTaskRequest;
import com.yolshin.ytask.model.dto.TaskFullResponse;
import com.yolshin.ytask.model.entity.Task;
import com.yolshin.ytask.service.entity.TaskEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskEntityService taskEntityService;

    public TaskFullResponse save(SimpleTaskRequest simpleTaskRequest) {
        Task task = new Task();
        task.setTitle(simpleTaskRequest.title());
        task.setDescription(simpleTaskRequest.description());

        Task taskFromBd =  taskEntityService.save(task);
        return new TaskFullResponse(taskFromBd.getId(), taskFromBd.getParent(), taskFromBd.getTitle(), taskFromBd.getDescription());
    }
}
