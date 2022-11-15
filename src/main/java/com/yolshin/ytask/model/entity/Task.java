package com.yolshin.ytask.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

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

    @ManyToOne
    @JoinColumn(name = "author_id")
    AppUser author;

    @Column(name = "task_status")
    Integer taskStatus;

    public TaskStatusEnum getTaskStatus() {
        return TaskStatusEnum.valueOf(taskStatus);
    }

    public void setTaskStatus(TaskStatusEnum taskStatus) {
        this.taskStatus = taskStatus.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task task = (Task) o;
        return id != null && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
