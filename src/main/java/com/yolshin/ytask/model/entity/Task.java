package com.yolshin.ytask.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@ToString
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "yt_task")
public class Task extends BaseTreeEntity {

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "author_id")
    UUID author;

    @Column(name = "task_status")
    Integer taskStatus;

    public TaskStatusEnum getTaskStatus() {
        return TaskStatusEnum.valueOf(taskStatus);
    }

    public void setTaskStatus(TaskStatusEnum taskStatus) {
        this.taskStatus = taskStatus.getValue();
    }
}
