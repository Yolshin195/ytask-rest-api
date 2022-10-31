package com.yolshin.ytask.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apt/v1/timer")
@Tag(name = "Timer REST API operations")
public class TimerController {

    @GetMapping("/start")
    @Operation(summary = "start timer")
    public void start() {

    }

    @GetMapping("/stop")
    @Operation(summary = "stop timer")
    public void stop() {

    }
}
