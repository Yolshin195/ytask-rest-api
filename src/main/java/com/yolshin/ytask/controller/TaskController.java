package com.yolshin.ytask.controller;


import com.yolshin.ytask.model.dto.SimpleTaskRequest;
import com.yolshin.ytask.model.dto.TaskFullResponse;
import com.yolshin.ytask.model.entity.Task;
import com.yolshin.ytask.service.TaskService;
import com.yolshin.ytask.service.entity.TaskEntityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "Task REST API operations")
public class TaskController extends BaseController {

    @Autowired
    TaskEntityService taskEntityService;

    @Autowired
    TaskService taskService;

    @PostMapping
    @Operation(
            summary = "create new Task",
            responses = @ApiResponse(responseCode = "201", description = "Success create task"))
    public ResponseEntity<TaskFullResponse> create(@RequestBody SimpleTaskRequest task) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.save(task));
    }

    @GetMapping
    public List<Task> getAll(@RequestParam(name = "page", defaultValue = "1") int page,
                             @RequestParam(name = "size", defaultValue = "10") int size) {
        PageRequest pr = PageRequest.of(page,size);
        return taskEntityService.findAll();
    }

    @GetMapping("/node/root")
    public List<TaskFullResponse> getRootNode() {
        return taskEntityService.getRootNode().stream()
                .map(t -> new TaskFullResponse(t.getId(), t.getParent(), t.getTitle(), t.getDescription()))
                .collect(Collectors.toList());
    }

    @GetMapping("/node/children")
    public List<TaskFullResponse> getChildrenNode(@RequestParam("parent") UUID parent) {
        return taskEntityService.getChildrenNode(parent).stream()
                .map(t -> new TaskFullResponse(t.getId(), t.getParent(), t.getTitle(), t.getDescription()))
                .collect(Collectors.toList());
    }

    private UUID getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null;
    }

}
