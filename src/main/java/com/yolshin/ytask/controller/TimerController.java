package com.yolshin.ytask.controller;

import com.yolshin.ytask.service.TimerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/apt/v1/timer")
@Tag(name = "Timer REST API operations")
public class TimerController {

    @Autowired
    TimerService timerService;

    @GetMapping("/start")
    @Operation(summary = "start timer")
    public void start(@RequestParam(name = "task_id") UUID taskId) {
        timerService.start(taskId);
    }

    @GetMapping("/stop")
    @Operation(summary = "stop timer")
    public void stop(@RequestParam(name = "id") UUID id) {
        timerService.stop(id);
    }

    @GetMapping("/time")
    @Operation(summary = "return all time to task")
    public Long getAllTime(@RequestParam(name = "task_id") UUID taskId) {
        return timerService.getAllTimeByTaskId(taskId);
    }
}
