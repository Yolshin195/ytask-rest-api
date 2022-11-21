package com.yolshin.ytask.service;

import com.yolshin.ytask.model.dto.SimpleTaskRequest;
import com.yolshin.ytask.model.dto.TaskFullResponse;
import com.yolshin.ytask.model.entity.Task;

public interface TaskService {
    TaskFullResponse save(SimpleTaskRequest taskRequest);

}
