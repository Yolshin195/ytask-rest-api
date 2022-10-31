package com.yolshin.ytask.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Getter
@Setter
@Table(name = "yt_task")
public class Task extends BaseTreeEntity {

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;

    @Column(name = "task_status")
    Integer taskStatus;

    public TaskStatusEnum getTaskStatus() {
        return TaskStatusEnum.valueOf(taskStatus);
    }

    public void setTaskStatus(TaskStatusEnum taskStatus) {
        this.taskStatus = taskStatus.getValue();
    }
}
