package com.yolshin.ytask.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Getter
@Setter
@Entity
@Table(name = "yt_role")
public class Role extends BaseEntity {

    @Column(name = "name")
    String name;
}
