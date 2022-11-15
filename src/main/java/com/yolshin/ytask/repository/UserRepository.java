package com.yolshin.ytask.repository;

import com.yolshin.ytask.model.entity.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseEntityRepository<AppUser> {
    AppUser findByUsernameAndDeleteTsIsNull(String username);

    boolean existsByUsernameAndDeleteTsIsNull(String username);
}
