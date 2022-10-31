package com.yolshin.ytask.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "yt_user")
public class User extends BaseEntity {

    @Column(name = "active")
    Boolean active;

    @Column(name = "username")
    String username;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
}
