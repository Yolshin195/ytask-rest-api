package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.User;
import com.yolshin.ytask.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseEntityServiceImpl<User> implements UserService  {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
