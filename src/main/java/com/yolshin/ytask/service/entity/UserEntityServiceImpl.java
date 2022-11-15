package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.AppUser;
import com.yolshin.ytask.model.entity.AppUserRole;
import com.yolshin.ytask.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntityServiceImpl extends BaseEntityServiceImpl<AppUser> implements UserEntityService {

    private final UserRepository repository;
    private final AppUserRoleEntityService appUserRoleEntityService;

    public UserEntityServiceImpl(UserRepository repository, AppUserRoleEntityService appUserRoleEntityService) {
        super(repository);
        this.repository = repository;
        this.appUserRoleEntityService = appUserRoleEntityService;
    }

    @Override
    public AppUser findByUsername(String username) {
        return repository.findByUsernameAndDeleteTsIsNull(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repository.existsByUsernameAndDeleteTsIsNull(username);
    }

    @Override
    public void deleteByUsername(String username) {
        AppUser user = findByUsername(username);

        super.delete(user);
    }

    @Override
    @Transactional
    public AppUser save(AppUser appUser) {

        List<AppUserRole> appUserRoleList = appUser.getAppRoles();
        appUser.setAppRoles(new ArrayList<>());

        appUser = super.save(appUser);

        if (appUserRoleList != null && !appUserRoleList.isEmpty()) {
            for (AppUserRole appUserRole : appUserRoleList) {
                appUserRole.setAppUser(appUser);
                appUserRole = appUserRoleEntityService.save(appUserRole);
            }
        }

        appUser.setAppRoles(appUserRoleList);

        return appUser;
    }
}
