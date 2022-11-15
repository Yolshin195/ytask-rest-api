package com.yolshin.ytask.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "yt_provide_access_task")
public class ProvideAccessTask extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;
}
