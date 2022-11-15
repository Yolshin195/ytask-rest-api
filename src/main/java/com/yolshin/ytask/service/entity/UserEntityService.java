package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.AppUser;

public interface UserEntityService extends BaseEntityService<AppUser> {
    AppUser findByUsername(String username);

    Boolean existsByUsername(String username);

    void deleteByUsername(String username);
}
