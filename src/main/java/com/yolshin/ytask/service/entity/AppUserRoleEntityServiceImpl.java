package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.AppUserRole;
import com.yolshin.ytask.repository.AppUserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserRoleEntityServiceImpl extends BaseEntityServiceImpl<AppUserRole> implements AppUserRoleEntityService {

    protected AppUserRoleRepository repository;

    public AppUserRoleEntityServiceImpl(AppUserRoleRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
