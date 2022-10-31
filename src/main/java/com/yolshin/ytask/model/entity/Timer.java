package com.yolshin.ytask.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Setter
@Getter
@Entity
@Table(name = "yt_timer")
public class Timer extends BaseEntity {

    @Column(name = "begin_time")
    LocalDateTime begin;

    @Column(name = "end_time")
    LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;
}
