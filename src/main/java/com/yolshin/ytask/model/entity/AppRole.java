package com.yolshin.ytask.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum AppRole implements GrantedAuthority {
  ROLE_ADMIN, ROLE_CLIENT;

  public String getAuthority() {
    return name();
  }

}