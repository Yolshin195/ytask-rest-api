package com.yolshin.ytask.controller;


import com.yolshin.ytask.model.dto.TaskFullResponse;
import com.yolshin.ytask.model.entity.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "Task REST API operations")
public class TaskController {

    @PostMapping
    @Operation(
            summary = "create new Task",
            responses = @ApiResponse(responseCode = "201", description = "Success create task"))
    public ResponseEntity<TaskFullResponse> create() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TaskFullResponse(UUID.randomUUID(), "new task", "new task decription"));
    }

}
