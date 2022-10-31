package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.Role;
import com.yolshin.ytask.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseEntityServiceImpl<Role> {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
