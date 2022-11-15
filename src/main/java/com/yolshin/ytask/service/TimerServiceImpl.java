package com.yolshin.ytask.service;

import com.yolshin.ytask.model.entity.Task;
import com.yolshin.ytask.model.entity.Timer;
import com.yolshin.ytask.service.entity.TaskEntityServiceImpl;
import com.yolshin.ytask.service.entity.TimerEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class TimerServiceImpl implements TimerService {

    @Autowired
    TimerEntityServiceImpl timerEntityService;

    @Autowired
    TaskEntityServiceImpl taskEntityService;

    public Timer start(UUID taskId) {
        Task task = taskEntityService.findById(taskId);

        Timer timer = new Timer();
        timer.setBegin(LocalDateTime.now());
        timer.setTask(task);

        return timerEntityService.save(timer);
    }

    public Timer stop(UUID id) {
        Timer timer = timerEntityService.findById(id);
        timer.setEnd(LocalDateTime.now());

        return timerEntityService.update(timer);
    }

    @Override
    public Long getAllTimeByTaskId(UUID taskId) {
        return timerEntityService.findByTaskId(taskId).stream().mapToLong(t -> ChronoUnit.MICROS.between(t.getEnd(), t.getBegin())).sum();
    }
}
