package com.yolshin.ytask.service;


import com.yolshin.ytask.model.entity.Timer;

import java.util.UUID;

public interface TimerService {
    Timer start(UUID taskId);
    Timer stop(UUID id);

    Long getAllTimeByTaskId(UUID taskId);
}
