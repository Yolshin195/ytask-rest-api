package com.yolshin.ytask.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "yt_user")
public class AppUser extends BaseEntity {

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "app_user_id")
    List<AppUserRole> appRoles;
}
