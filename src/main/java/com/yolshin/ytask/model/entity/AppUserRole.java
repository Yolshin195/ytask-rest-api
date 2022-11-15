package com.yolshin.ytask.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "YT_APP_USER_ROLE")
public class AppUserRole extends BaseEntity implements GrantedAuthority {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    AppUser appUser;

    @Column(name = "app_role")
    String appRole;

    public String getAuthority() {
        return appRole;
    }
}
